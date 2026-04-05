Capstone Project (Subscription Billing System)

# Subscription Billing System

## Features
- User creation
- Plan creation (monthly/yearly)
- Subscribe / Cancel subscription
- Billing generation

## Tech Stack
- Spring Boot
- Maven
- H2 Database
- JPA

## API Endpoints

### User
POST /users  
GET /users

### Plan
POST /plans  
GET /plans

### Subscription
POST /subscriptions/subscribe  
POST /subscriptions/cancel  
GET /subscriptions/{userId}

### Billing
GET /billing/{subscriptionId}

## How to Run
1. Open project in IntelliJ
2. Run main class
3. Use Postman to test APIs