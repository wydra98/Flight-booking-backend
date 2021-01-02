# backend

## Uruchomienie projektu
### Konfiguracja bazy danych
Zmodyfikuj ```spring.datasource.url=YOUR_PATH_TO_DB``` w application.properites z poprawnym adresem url do twojego pliku db. 

### Podgląd bazy danych w przeglądarce
Po uruchomieniu projektu wprowadź następujący adres URL
```http://localhost:8080/console```

### Podgląd bazy danych w IntelliJ IDEA Ultimate
Po uruchomieniu projektu wybierz zakładkę Database, dodaj nową bazę danych i ustaw 
poprawny adres url do twojego pliku db. 

```http://localhost:8080/console```

## Technologie
* Java 11
* Spring Boot 2.2.6
* Baza danych h2
* Flyway 
* Lombok 
* Swagger

## Schematy
### DTO
![UML](./diagrams/dtos/dtos.svg)

### Entites
![UML](./diagrams/entities/entities.svg)

### Baza danych
![UML](./diagrams/database/database.png)
