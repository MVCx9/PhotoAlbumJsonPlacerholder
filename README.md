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
./mvnw clean install
```

### Run the Application

To run the application, use the following command:

```sh
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

## Endpoints
- **_GET /albums:_** Returns a list of all albums.
- **_GET /albums/{albumId}/photos:_** Returns a list of photos for the specified album by albumId.

## Running Tests

To run the tests, use the following command:

```sh
./mvnw test
```

## Contributions
Contributions are welcome. Please follow the guidelines established in the [CONTRIBUTING](CONTRIBUTING.md) file.

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
This project is licensed under the MIT License. For more details, see the [LICENSE](LICENSE.md) file.