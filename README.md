# quarkus-auth0-sample


## What is this?

This is a sample project demos how to use OAuth2/Oidc and Auth0 idp service to secure Quarkus applications. 

> If you are interested in the custom JWT authentication with the Spring WebMvc stack, check [spring-webmvc-jwt-sample](https://github.com/hantsy/spring-webmvc-jwt-sample/) for more details.

> If you are interested in the custom JWT authentication with the Spring WebFlux stack, check [spring-reactive-jwt-sample](https://github.com/hantsy/spring-reactive-jwt-sample/) for more details.

## Guide

TBD.

## Prerequisites

Make sure you have installed the following software.

* Java 16
* Apache Maven 3.8.x
* Docker

## Build 

Clone the source codes from Github.

```bash
git clone https://github.com/hantsy/quarkus-auth0-sample
```

Open a terminal, and switch to the root folder of the project, and run the following command to build the whole project.

```bash
docker-compose up postgres // start up a postgres
mvn clean install // build the project
```

Run the application.

```bash
mvn quarkus:dev
// or from command line after building
java -jar target/xxx.jar
```


## Contribution

Any suggestions are welcome, filing an issue or submitting a PR is also highly recommended.  



## References

* [Quarkus - Using OpenID Connect to Protect Service Applications using Bearer Token Authorization](https://quarkus.io/guides/security-openid-connect)
