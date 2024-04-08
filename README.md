# Enterprise Device Management System

Questo progetto offre una soluzione completa per la gestione e l'assegnazione dei dispositivi aziendali (come smartphone, tablet e laptop) ai dipendenti, utilizzando Spring Boot per il backend e un database relazionale per la persistenza dei dati. Consente operazioni CRUD sui dipendenti e sui dispositivi, gestisce lo stato di assegnazione dei dispositivi e supporta l'upload di immagini profilo per i dipendenti.


## Caratteristiche

- **Gestione Dipendenti**: Crea, leggi, aggiorna ed elimina informazioni sui dipendenti, inclusi username, nome, cognome e email.
- **Gestione Dispositivi**: Amministra i dispositivi con la possibilità di assegnarli ai dipendenti, segnarli come disponibili, in manutenzione o dismessi.
- **Assegnazione Dispositivi**: Permette l'assegnazione dei dispositivi ai dipendenti attraverso un endpoint specifico.
- **Upload Immagini**: Consente ai dipendenti di caricare le proprie immagini profilo.


## Tecnologie Utilizzate

- **Spring Boot**: Framework per lo sviluppo di applicazioni Java con servizi web RESTful.
- **Database Relazionale (come MySQL, PostgreSQL)**: Per la persistenza dei dati relativi a dipendenti e dispositivi.
- **Hibernate**: ORM utilizzato per facilitare l'integrazione tra Java e il database relazionale.
- **Spring Data JPA**: Per semplificare l'accesso ai dati nel database.
- **Spring Web MVC**: Per costruire e gestire i servizi web RESTful.


## Come iniziare

Queste istruzioni ti forniranno una copia del progetto in esecuzione sul tuo computer locale per scopi di sviluppo e test.


## Prerequisiti

- JDK 1.8 o superiore
- Maven 3.3+
- Un'istanza di database relazionale (MySQL/PostgreSQL)
- Un account Cloudinary per l'upload delle immagini


## Installazione
1. Clona il repository:

***git clone https://github.com/tuo-username/sistema-gestione-dispositivi-aziendali.git***

2. Nella cartella principale del progetto, crea un file application.properties (o modifica quello esistente) aggiungendo le seguenti configurazioni per il database e Cloudinary:
   ***spring.datasource.url=jdbc:your_database_url
      spring.datasource.username=your_database_username
      spring.datasource.password=db_password
      spring.jpa.hibernate.ddl-auto=update

      cloudinary.cloud_name=cloudinary_name
      cloudinary.api_key=cloudinary_key
      cloudinary.api_secret=cloudinary_secret***
   
   Assicurati di sostituire your_database_url, your_database_username, db_password, cloudinary_name, cloudinary_key, e cloudinary_secret con i tuoi dati effettivi.

4. Compila e avvia l'applicazione:
   ***mvn clean install
mvn spring-boot:run***


## Utilizzo

Una volta avviato il servizio, puoi interagire con esso utilizzando qualsiasi client HTTP (come Postman o curl) per inviare richieste ai vari endpoint esposti dal servizio.

### Endpoint Dispositivi

 **Salva un Dispositivo**:

- Metodo: POST
  - **URL**: /devices
  - **Descrizione**: Crea un nuovo dispositivo.
  - **Corpo della Richiesta**: Un oggetto JSON che rappresenta il nuovo dispositivo.
  - **Risposta**: Restituisce il dispositivo appena creato.

- **Recupera tutti i Dispositivi**:

  - **Metodo**: GET
  - **URL**: /devices
  - **Descrizione**: Recupera tutti i dispositivi presenti nel sistema.
  - **Parametri Query**:
    - `page` (opzionale): Numero della pagina desiderata (default: 0)
    - `size` (opzionale): Dimensione della pagina (default: 15)
    - `orderBy` (opzionale): Campo su cui ordinare i dispositivi (default: id)

- **Recupera un Dispositivo per ID**:

  - **Metodo**: GET
  - **URL**: /devices/{id}
  - **Descrizione**: Recupera un dispositivo specifico tramite il suo ID.

- **Aggiorna un Dispositivo per ID**:

  - **Metodo**: PUT
  - **URL**: /devices/{id}
  - **Descrizione**: Aggiorna le informazioni di un dispositivo esistente.
  - **Corpo della Richiesta**: Un oggetto JSON che rappresenta le nuove informazioni del dispositivo.
  - **Risposta**: Restituisce il dispositivo aggiornato.
  
- **Elimina un Dispositivo per ID**:

  - **Metodo**: DELETE
  - **URL**: /devices/{id}
  - **Descrizione**: Elimina un dispositivo dal sistema.

### Endpoint Dipendenti

- **Salva un Dipendente**:

  - **Metodo**: POST
  - **URL**: /employees
  - **Descrizione**: Crea un nuovo dipendente.
  - **Corpo della Richiesta**: Un oggetto JSON che rappresenta il nuovo dipendente.
  - **Risposta**: Restituisce il dipendente appena creato.
  
- **Recupera tutti i Dipendenti**:

  - **Metodo**: GET
  - **URL**: /employees
  - **Descrizione**: Recupera tutti i dipendenti presenti nel sistema.
  - **Parametri Query**:
    - `page` (opzionale): Numero della pagina desiderata (default: 0)
    - `size` (opzionale): Dimensione della pagina (default: 15)
    - `orderBy` (opzionale): Campo su cui ordinare i dipendenti (default: id)

- **Recupera un Dipendente per ID**:

  - **Metodo**: GET
  - **URL**: /employees/{id}
  - **Descrizione**: Recupera un dipendente specifico tramite il suo ID.

- **Aggiorna un Dipendente per ID**:

  - **Metodo**: PUT
  - **URL**: /employees/{id}
  - **Descrizione**: Aggiorna le informazioni di un dipendente esistente.
  - **Corpo della Richiesta**: Un oggetto JSON che rappresenta le nuove informazioni del dipendente.
  - **Risposta**: Restituisce il dipendente aggiornato.

- **Carica un'Immagine Profilo per un Dipendente**:

  - **Metodo**: POST
  - **URL**: /employees/{id}/uploadImg
  - **Descrizione**: Carica un'immagine profilo per un dipendente specifico.
  - **Parametri**:
    `id`: ID del dipendente.
    `profileImg`: File dell'immagine da caricare.
  - **Risposta**: Restituisce il dipendente con l'immagine profilo aggiornata.
    
- **Elimina un Dipendente per ID**:

  - **Metodo**: DELETE
  - **URL**: /employees/{id}
  - **Descrizione**: Elimina un dipendente dal sistema.

## Gestione Errori

Il servizio gestisce varie situazioni di errore, restituendo appropriati status code HTTP e messaggi di errore in caso di dati non validi, risorse non trovate, o violazioni di vincoli.
