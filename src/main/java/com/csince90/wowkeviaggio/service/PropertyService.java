package com.csince90.wowkeviaggio.service;

import com.csince90.wowkeviaggio.model.Property;
import com.csince90.wowkeviaggio.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    public Property updateProperty(Long id, Property propertyDetails) {
        Property property = propertyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Property not found"));
        property.setNome(propertyDetails.getNome());
        property.setLocation(propertyDetails.getLocation());
        property.setPrezzo(propertyDetails.getPrezzo());
        property.setPiattaforma(propertyDetails.getPiattaforma());
        return propertyRepository.save(property);
    }
}