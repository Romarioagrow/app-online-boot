# app-online-boot

## Local profile

Create `src/main/resources/application-local.properties` (ignored by git) and set
your local database credentials, for example:

```
spring.datasource.url=jdbc:postgresql://localhost/your-base
spring.datasource.username=your-name
spring.datasource.password=change_me
```

Run with the local profile:

```
mvn spring-boot:run -Dspring-boot.run.profiles=local
```
