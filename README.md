# Microservices Project
This project demonstrates a microservices architecture using Spring Boot. It includes four main services: School Service, Student Service, Registry Service, and API Gateway. This setup showcases service registration and inter-service communication without a database.

Services Overview

1.School Service
  Purpose: Manages school-related operations.
  Communication: Provides endpoints consumed by the Student Service via RestTemplate.
  
2.Student Service
  Purpose: Manages student-related operations.
  Communication: Uses RestTemplate to interact with the School Service.

3.Registry Service  
  Purpose: Registers all microservices and enables service discovery.
  Technology: Spring Cloud Netflix Eureka.
  
4.API Gateway Service
Purpose: Acts as the entry point for all client requests, routing them to the appropriate microservice.
Technology: Spring Cloud Gateway

Prerequisites

1.  Java 17 or later
2.  Maven 3.6.3 or later
3.  Spring Boot 3.x
