# Photo Albums Application

This project is a sample application developed with Spring Boot and Kotlin. It provides an API to obtain a list of albums and the details of photos in each album using data from [JSONPlaceholder](https://jsonplaceholder.typicode.com).

It will help you to enhance your skills in Kotlin and Spring Boot by providing a practical example of how to build a RESTful API with these technologies.

## Technologies Used

- **Kotlin:** A modern and safe programming language for application development.
- **Spring Boot:** A framework that simplifies enterprise application development.
- **Maven:** A project management and build tool.

## Project Architecture
The application follows the hexagonal architecture pattern (ports and adapters) to ensure a modular and maintainable structure. The main components are:

- Controllers: Handle HTTP requests and delegate business logic to the service.
- Services: Contain the application's business logic.
- Clients: Make calls to external services such as JSONPlaceholder.
- Configuration: Manages the configuration of application components like RestTemplate and ObjectMapper.
- Entity: Define the data models used in the application.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- You have installed [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- You have installed [Maven](https://maven.apache.org/install.html).
- You have installed [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or other IDE.

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/your-username/photoalbums.git
```
```sh
cd photoalbums
```
### Build the Project

To build the project, run the following command:

```sh
./mvn clean install
```

### Run the Application

To run the application, use the following command:

```sh
./mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## Running Tests

To run the tests, use the following command:

```sh
./mvn test
```

## Accessing Swagger UI Documentation

This application provides interactive API documentation using [Swagger UI](https://swagger.io/tools/swagger-ui/). Swagger UI allows you to explore and test the available endpoints in your API directly from the browser.

### How to Access

1. **Start the Application**: Make sure the application is running. 
   
2. **Open Swagger UI**: Once the application is running, open your browser and navigate to:
 http://localhost:8080/swagger-ui/index.html

Here, you'll find the full API documentation with the available endpoints, request parameters, and response types.

### Testing Endpoints via Swagger UI

1. **Select an Endpoint**: On the Swagger UI page, you'll see a list of endpoints grouped by their controllers or features. Click on an endpoint to expand its details.

2. **Input Parameters**: For endpoints that require parameters (like path variables, query parameters, or request bodies), Swagger UI will present you with input fields to fill in the required data.

3. **Execute the Request**: After filling in the necessary details, click the **"Try it out"** button followed by **"Execute"**. Swagger UI will send the request to the server and display the response, including status code, headers, and the response body.

4. **Review Responses**: The response section will show the result of your request, which helps in verifying the behavior and output of each endpoint.

### Viewing the OpenAPI Specification

If you need to see the raw OpenAPI specification (in YAML format), it can be accessed via: 
http://localhost:8080/v3/api-docs.yaml

or

If you need to see the raw OpenAPI specification (in JSON format), it can be accessed via: 
http://localhost:8080/v3/api-docs

## Documentation and Resources

Here are some useful links to documentation and resources to help you better understand and work with Kotlin and Spring Boot:

- [Spring Framework Reference for Kotlin](https://docs.spring.io/spring-framework/reference/languages/kotlin.html)
- [JetBrains Exposed](https://github.com/JetBrains/Exposed)
- [Kotlin Articles at Programando o Intentándolo](https://programandoointentandolo.com/kotlin/page/2)
- [Kotlin Guide - Develou](https://www.develou.com/guia-de-kotlin/)
- [Inheritance in Kotlin - Develou](https://www.develou.com/herencia-en-kotlin/)
- [For Loop in Kotlin - Develou](https://www.develou.com/for-en-kotlin/)
- [Kotlin with Spring - Baeldung](https://www.baeldung.com/kotlin/category/spring)
- [Kotlin SlideShare](https://es.slideshare.net/slideshow/9054799-dzonerefcard267kotlin/218841101)  
- [Kotlin Reference Documentation](https://kotlinlang.org/docs/reference/)
- [Kotlin Programming Language](https://kotlinlang.org/)
- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Boot with Kotlin - Baeldung](https://www.baeldung.com/spring-boot-kotlin)
- [Spring Initializr](https://start.spring.io/)
- [Spring Framework Reference Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
- [Spring Framework Guides](https://spring.io/guides)

## License
This project is licensed under the MIT License.