# Read Me First

## Local setup

* Start up local Redis `docker run --name local-redis -p 6379:6379 --rm redis:7.0.8`
* Start the app `./gradlew bootRun`
* Play with GET and POST request, observe execution time
```curl
curl -v http://localhost:8080/api/players/23
* ```
```curl
curl -v  http://localhost:8080/api/players -H "Content-Type: application/json" -d "{\"id\":101, \"firstName\":\"Michael\", \"lastName\":\"Jordan\"}"
* ```
```curl
curl -v http://localhost:8080/api/players/101
* ```

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Cache Abstraction [current]](https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#cache)
* [Spring Cache abstraction [3.0.2]](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#io.caching)
* [Redis at DockerHub](https://hub.docker.com/_/redis)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.nosql.redis)

### Guides
The following guides illustrate how to use some features concretely:

* [Caching Data with Spring](https://spring.io/guides/gs/caching/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
