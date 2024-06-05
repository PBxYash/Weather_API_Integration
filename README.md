

# Weather API Integration

This project is a Spring Boot application that integrates with the OpenWeatherMap API to fetch current weather data for a given latitude and longitude.

=

## Prerequisites

- Java 17 or later
- Maven

## Installation

The application will start on port 8081 by default.


1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Endpoints

### Fetch Book Details

- **URL:** `/weather`
- **Method:** `POST`
- **Request:**
    ```json
    {
        "latitude": "12.45",
        "longitude": "12.45",
        "apiKey": "bd5e378503939ddaee76f12ad7a97608",
        "units": "metric"
    }
    ```
- **Response:**
    ```json
    {
     "longitude": 12.45,
     "latitude": 12.45,
     "temperature": 34.89,
     "weather_description": "scattered clouds",
     "feels_like": 33.94,
     "minimum_temperature": 34.89,
     "maximum_temperature": 34.89
  }
    ```


    ```

## Testing with Postman

1. Open Postman.
2. Create a new POST request.
3. Set the request URL to:
    ```
    http://localhost:8081/weather?latitude={YOUR_LATITUDE}&longitude={YOUR_LONGITUDE}&apiKey={YOUR_API_KEY}&units=YOUR_UNITS

    ```
    ```
4.Send the request and check the response.

## Swagger UI

Swagger UI is available to explore and test the API endpoints.

1. Open a web browser.
2. Navigate to the Swagger UI:
    ```
    http://localhost:8081/swagger-ui.html
    ```
3. Use the Swagger UI to test the API endpoints.

## Configuration

You can externalize any necessary configuration properties using `src/main/resources/application.properties` or `src/main/resources/application.yml`.

## Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.3.0</version>
    </dependency>
</dependencies>
