package com.csince90.wowkeviaggio.service;

import com.csince90.wowkeviaggio.model.Service; // Il tuo modello
import com.csince90.wowkeviaggio.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // Usa @Component invece di @Service per evitare conflitti
public class ServiceBooster {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public Service updateService(Long id, Service serviceDetails) {
        Service service = serviceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Service not found"));
        service.setNome(serviceDetails.getNome());
        return serviceRepository.save(service);
    }
}