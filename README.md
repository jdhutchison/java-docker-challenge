Technical Challenge API
=======================

The Application
---------------
The template API application uses Spring and Spring Boot to
make a simple scafolding for building a Java based API. 

Spring was selected due to its wide use and being familiar
(to some degree) to most Java developers. It also has a lot of 
modules or capabilities that are easy to import and use (especially 
with Spring Boot).

### Limitations
There's no security or CORS configured or set up. This would need to be added
seperately through something like Spring Security (for security), for example.

There's no explicit logging configuration either. For simplicity any
log settings are simply done through Spring Boot configuration.

In terms of a _metadata file_ for including all the information returned
by /status I've just used the `application.yaml` file to hold those
values rather than a separate file, and then set whatever value
are required in the CI pipeline. 

### Operations
This scaffold API implements two operations:
- /: As specified, the index URI that returns some 'Hello World' type value. 
- /status: Also as specified, returns some basic details about the app in a slightly odd format.

As well as having Spring Boot actuators enabled and exposed.

### To operate

#### Tests
To run the unit test suite run:

```
./gradlew clean test
```

#### Running the application

To run the application either use gradle's bootRun target locally:

```
./gradlew bootRun
```

OR build the application, then build and run the docker image:

```
./gradlew clean build
docker build -t challenge .
docker run -p 8080:8080 challenge .
```
The application will be available at http://localhost:8080/ for either option. 
