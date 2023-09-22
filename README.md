## News registration API

This is a sample project for a backend application developed in Java 17, using the Spring Boot framework, and a PostgreSQL database to create an API. The API is managed by the `News registration`, which handles operations related to academic events.

## Prerequisites

Before you begin, make sure you have the following prerequisites installed:

- [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Docker](https://www.docker.com/get-started)

## Configuration

1. Clone the repository:

```bash
git clone https://github.com/your-username/your-repository.git
cd your-repository


PostgreSQL database in the application.properties 
spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password

Run the application:
./mvnw spring-boot:run

Run the Docker Compose command to build and start the containers:
docker-compose up -d

### Endpoints da API

| Método | Endpoint                         | Descrição                                |
| ------ | -------------------------------- | ---------------------------------------- |
| POST   | `/api/AcademicEvents`            | Cria um novo evento acadêmico.          |
| GET    | `/api/AcademicEvents`            | Lista todos os eventos acadêmicos.      |
| GET    | `/api/AcademicEvents/{id}`       | Retorna um evento acadêmico pelo seu ID. |
