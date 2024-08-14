# Wowkeviaggio

Wowkeviaggio è un'applicazione Spring Boot progettata per gestire prenotazioni di viaggi e proprietà. 
Include funzionalità come gestione utenti, pagamenti, servizi associati alle proprietà, e un sistema di sicurezza basato su JWT (JSON Web Token).

## Struttura del Progetto

Il progetto è organizzato secondo il modello MVC (Model-View-Controller) con una particolare enfasi sulla separazione delle responsabilità tra diversi componenti.

### Controller

I controller gestiscono le richieste HTTP e collegano il frontend con il backend. Essi includono:

- **`GeneralBookingController`**: Gestisce le operazioni relative alle prenotazioni generali, come la creazione, aggiornamento e cancellazione delle prenotazioni.
- **`PaymentController`**: Gestisce le transazioni di pagamento, inclusa l'elaborazione e verifica dei pagamenti.
- **`PropertyController`**: Gestisce le operazioni sulle proprietà, come l'aggiunta, modifica e visualizzazione delle proprietà disponibili.
- **`ServiceController`**: Gestisce i servizi associati alle proprietà, come l'aggiunta di servizi extra durante la prenotazione.
- **`UserController`**: Gestisce la registrazione degli utenti, autenticazione, e operazioni correlate agli account utente.

### Model

I modelli rappresentano le entità nel sistema e sono mappati al database. I modelli principali includono:

- **`GeneralBooking`**: Rappresenta una prenotazione generale fatta da un utente per una proprietà.
- **`Payment`**: Rappresenta un pagamento effettuato da un utente per una prenotazione.
- **`Property`**: Rappresenta una proprietà disponibile per la prenotazione.
- **`PropertyService`**: Rappresenta i servizi aggiuntivi disponibili per una proprietà.
- **`User`**: Rappresenta un utente registrato nell'applicazione.

### Service

I servizi contengono la logica di business dell'applicazione. Includono:

- **`GeneralBookingService`**: Contiene la logica per gestire le prenotazioni, come la validazione e il salvataggio delle stesse.
- **`PaymentService`**: Gestisce la logica di pagamento, compresa l'integrazione con i gateway di pagamento.
- **`PropertyService`**: Gestisce la logica relativa alle proprietà, come la disponibilità e la gestione dei dettagli.
- **`UserService`**: Gestisce la logica relativa agli utenti, come la registrazione e autenticazione.
- **`ServiceBooster`**: Probabilmente un servizio ausiliario per potenziare o migliorare altre funzionalità.

### Security

Il sistema di sicurezza è basato su JWT e include:

- **`JwtAuthenticationFilter`**: Filtro per gestire e convalidare i token JWT per le richieste.
- **`JwtService`**: Gestisce la creazione e la validazione dei token JWT.
- **`SecurityConfig`**: Configura le impostazioni di sicurezza dell'applicazione, come le rotte protette e le politiche di accesso.
- **`MyUserDetailsService`**: Fornisce i dettagli dell'utente per l'autenticazione.

### Repository

I repository forniscono l'accesso ai dati e implementano operazioni CRUD (Create, Read, Update, Delete). I principali repository includono:

- **`GeneralBookingRepository`**: Gestisce le operazioni sul database per le prenotazioni.
- **`PaymentRepository`**: Gestisce le operazioni sul database per i pagamenti.
- **`PropertyRepository`**: Gestisce le operazioni sul database per le proprietà.
- **`UserRepository`**: Gestisce le operazioni sul database per gli utenti.
