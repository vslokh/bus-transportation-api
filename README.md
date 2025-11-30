# 🚌 Bus Transportation API

A RESTful API built with **Spring Boot 3.2.1** and **Java 23** for managing bus routes and buses. This project demonstrates Spring Boot fundamentals including JPA, REST APIs, validation, and exception handling with H2 in-memory database.

## 📋 Features

- ✅ Create and retrieve bus routes
- ✅ Add buses to routes
- ✅ Search buses by route
- ✅ H2 in-memory database (no external database needed)
- ✅ Input validation with Bean Validation
- ✅ Global exception handling
- ✅ RESTful API design
- ✅ Detailed code comments for learning

## 🛠️ Technologies Used

- **Java 23**
- **Spring Boot 3.2.1**
- **Spring Data JPA** - Database operations
- **H2 Database** - In-memory database
- **Maven** - Build tool
- **Jakarta Validation** - Input validation

## 🚀 Getting Started

### Prerequisites

- Java 23 or higher installed
- Maven 3.6+ installed (or use Maven wrapper)

### Installation & Running

1. **Clone the repository**
```bash
git clone https://github.com/vslokh/bus-transportation-api.git
cd bus-transportation-api
```

2. **Build the project**
```bash
mvn clean install
```

3. **Run the application**
```bash
mvn spring-boot:run
```

The API will start on `http://localhost:8080`

### Access H2 Database Console

While the application is running, visit: `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** *(leave empty)*

## 📚 API Endpoints

### 1. Create a Bus Route

**POST** `/transport/route`

**Request Body:**
```json
{
  "title": "Route 101",
  "source": "Downtown",
  "destination": "Airport",
  "stations": "Station A, Station B, Station C"
}
```

**Response:** `201 CREATED`
```json
{
  "id": 1,
  "title": "Route 101",
  "source": "Downtown",
  "destination": "Airport",
  "stations": "Station A, Station B, Station C"
}
```

### 2. Get Route by ID (with buses)

**GET** `/transport/route/{id}`

**Response:** `200 OK`
```json
{
  "id": 1,
  "title": "Route 101",
  "source": "Downtown",
  "destination": "Airport",
  "stations": "Station A, Station B, Station C",
  "buses": [
    {
      "id": 1,
      "busNo": "BUS-001",
      "color": "Blue",
      "capacity": 50,
      "routeId": 1
    }
  ]
}
```

### 3. Add a Bus to a Route

**POST** `/transport/bus`

**Request Body:**
```json
{
  "busNo": "BUS-001",
  "color": "Blue",
  "capacity": 50,
  "routeId": 1
}
```

**Response:** `201 CREATED`
```json
{
  "id": 1,
  "busNo": "BUS-001",
  "color": "Blue",
  "capacity": 50,
  "routeId": 1
}
```

### 4. Search Buses by Route ID

**GET** `/transport/bus/search/{routeId}`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "busNo": "BUS-001",
    "color": "Blue",
    "capacity": 50,
    "routeId": 1
  },
  {
    "id": 2,
    "busNo": "BUS-002",
    "color": "Red",
    "capacity": 45,
    "routeId": 1
  }
]
```

## 🧪 Testing with cURL

### Create a Route
```bash
curl -X POST http://localhost:8080/transport/route \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Route 101",
    "source": "Downtown",
    "destination": "Airport",
    "stations": "Station A, Station B, Station C"
  }'
```

### Get Route by ID
```bash
curl http://localhost:8080/transport/route/1
```

### Add a Bus
```bash
curl -X POST http://localhost:8080/transport/bus \
  -H "Content-Type: application/json" \
  -d '{
    "busNo": "BUS-001",
    "color": "Blue",
    "capacity": 50,
    "routeId": 1
  }'
```

### Search Buses by Route
```bash
curl http://localhost:8080/transport/bus/search/1
```

## 🏗️ Project Structure

```
src/main/java/com/busapp/
├── BusTransportationApplication.java  # Main Spring Boot application
├── controller/
│   ├── BusController.java            # REST endpoints for buses
│   └── BusRouteController.java       # REST endpoints for routes
├── dto/
│   ├── BusRequest.java               # Request DTO for creating bus
│   ├── BusResponse.java              # Response DTO for bus data
│   ├── BusRouteRequest.java          # Request DTO for creating route
│   └── BusRouteResponse.java         # Response DTO for route data
├── entity/
│   ├── Bus.java                      # Bus entity (JPA)
│   └── BusRoute.java                 # BusRoute entity (JPA)
├── exception/
│   ├── GlobalExceptionHandler.java   # Global exception handler
│   └── InvalidRouteIdException.java  # Custom exception
├── repository/
│   ├── BusRepository.java            # Data access for Bus
│   └── BusRouteRepository.java       # Data access for BusRoute
└── service/
    ├── BusService.java               # Business logic for buses
    └── BusRouteService.java          # Business logic for routes
```

## 🎓 Learning Resources

This project includes extensive inline comments explaining:
- Spring Boot annotations (@RestController, @Service, @Repository, etc.)
- JPA relationships (@OneToMany, @ManyToOne)
- Bean Validation (@Valid, @NotBlank, @NotNull)
- Exception handling (@ControllerAdvice, @ExceptionHandler)
- DTO pattern for API design

## 📄 License

This project is open source and available for educational purposes.

## 👤 Author

**Vinayak Lokhande**
- GitHub: [@vslokh](https://github.com/vslokh)

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

Built with ❤️ using Spring Boot
