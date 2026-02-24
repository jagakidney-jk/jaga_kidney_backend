# JAGA Kidney -- Backend TODO (Spring Boot)

## Project Setup & Foundation

### Project Initialization

-   [X] Create Spring Boot project
    -   Dependencies:
        -   Spring Web
        -   Spring Data JPA
        -   Spring Security
        -   MySQL Driver
        -   Lombok
        -   Validation
        -   Spring Boot Actuator
        -   Swagger (springdoc-openapi)
-   [X] Setup package structure

    com.jaga.kidney
     ├── config
     ├── controller
     ├── service
     ├── repository
     ├── entity
     ├── dto
     ├── mapper
     ├── security
     ├── exception
     ├── util
     └── audit

-   [ ] Configure application-dev.yml
-   [ ] Configure application-prod.yml
-   [ ] Setup environment profiles

------------------------------------------------------------------------

## Database Configuration

-   [ ] Configure MySQL connection
-   [ ] Configure Hibernate settings
-   [ ] Enable JPA Auditing

### BaseEntity Fields

-   [ ] id
-   [ ] created_at
-   [ ] updated_at
-   [ ] created_by
-   [ ] status

------------------------------------------------------------------------

## Core Infrastructure

### Global Exception Handling

-   [ ] Create BaseException
-   [ ] Create ErrorResponse DTO
-   [ ] Create GlobalExceptionHandler

Handle: - \[ \] ResourceNotFoundException - \[ \] ValidationException -
\[ \] UnauthorizedException - \[ \] ConflictException - \[ \]
InternalServerException

------------------------------------------------------------------------

### Standard API Response Wrapper

    ApiResponse<T>
     - success
     - message
     - data
     - timestamp

------------------------------------------------------------------------

### Logging

-   [ ] Configure structured logging
-   [ ] Add request logging filter
-   [ ] Enable log rotation support

------------------------------------------------------------------------

## Security Module (JWT)

### User Entity

-   [ ] id
-   [ ] email
-   [ ] password
-   [ ] role
-   [ ] status

### Roles

-   [ ] PATIENT
-   [ ] STAFF
-   [ ] ADMIN

### JWT Infrastructure

-   [ ] Create JwtUtil
-   [ ] Create JwtFilter
-   [ ] Configure Spring Security
-   [ ] Role-based access control

### Auth APIs

-   [ ] POST /auth/login
-   [ ] POST /auth/register
-   [ ] GET /auth/me

------------------------------------------------------------------------

## Patient Module

### PatientProfile Entity

-   [ ] id
-   [ ] user_id
-   [ ] name
-   [ ] age
-   [ ] gender
-   [ ] phone
-   [ ] medical_notes

### APIs

-   [ ] GET /patients/{id}
-   [ ] PUT /patients/{id}
-   [ ] GET /patients/me

------------------------------------------------------------------------

## Machine Module

### Machine Entity

-   [ ] id
-   [ ] machine_code
-   [ ] status

### APIs

-   [ ] POST /machines
-   [ ] GET /machines
-   [ ] PUT /machines/{id}
-   [ ] DELETE /machines/{id}

------------------------------------------------------------------------

## Staff Module

### Staff Entity

-   [ ] id
-   [ ] user_id
-   [ ] name
-   [ ] role

### APIs

-   [ ] POST /staff
-   [ ] GET /staff
-   [ ] PUT /staff/{id}

------------------------------------------------------------------------

## Appointment Module

### Appointment Entity

-   [ ] id
-   [ ] patient_id
-   [ ] machine_id
-   [ ] staff_id
-   [ ] appointment_time
-   [ ] duration
-   [ ] status

### Business Logic

-   [ ] Conflict detection logic
-   [ ] Prevent double booking
-   [ ] Machine availability validation

### APIs

-   [ ] POST /appointments
-   [ ] GET /appointments/my
-   [ ] PUT /appointments/{id}
-   [ ] DELETE /appointments/{id}
-   [ ] GET /appointments (Admin)

------------------------------------------------------------------------

## Dialysis Session Module

### DialysisSession Entity

-   [ ] id
-   [ ] appointment_id
-   [ ] ultrafiltration
-   [ ] blood_pressure
-   [ ] weight
-   [ ] medications
-   [ ] complications
-   [ ] notes
-   [ ] start_time
-   [ ] end_time

### APIs

-   [ ] POST /sessions
-   [ ] PUT /sessions/{id}
-   [ ] GET /sessions/{id}
-   [ ] GET /sessions/my

------------------------------------------------------------------------

## Notification Module

### Notification Entity

-   [ ] id
-   [ ] user_id
-   [ ] title
-   [ ] message
-   [ ] read_status

### APIs

-   [ ] GET /notifications/my
-   [ ] POST /notifications/broadcast
-   [ ] PUT /notifications/{id}/read

------------------------------------------------------------------------

## Messaging Module

### Message Entity

-   [ ] id
-   [ ] sender_id
-   [ ] receiver_id
-   [ ] content
-   [ ] timestamp

### APIs

-   [ ] POST /messages
-   [ ] GET /messages/{userId}

------------------------------------------------------------------------

## Audit Log Module

### AuditLog Entity

-   [ ] id
-   [ ] action
-   [ ] entity
-   [ ] entity_id
-   [ ] performed_by
-   [ ] timestamp

------------------------------------------------------------------------

## Analytics Module

### Reports

-   [ ] Machine utilization report
-   [ ] Missed appointments report
-   [ ] Attendance report

### APIs

-   [ ] GET /analytics/machine-utilization
-   [ ] GET /analytics/attendance
-   [ ] GET /analytics/missed-sessions

------------------------------------------------------------------------

## Swagger Documentation

-   [ ] Enable OpenAPI
-   [ ] Document all endpoints

URL: /swagger-ui.html

------------------------------------------------------------------------

## Deployment Preparation

-   [ ] Configure production profile
-   [ ] Externalize configs
-   [ ] Configure DB credentials via environment variables

------------------------------------------------------------------------

## Production Readiness Checklist

-   [ ] All APIs secured
-   [ ] Proper exception handling
-   [ ] Audit logging enabled
-   [ ] Swagger complete
-   [ ] Logs verified
-   [ ] Backup strategy ready
