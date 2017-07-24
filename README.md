# Wunderground wrapper - API

Java REST service which is wrapper for the Weather Underground API. It can deliver weather forecast for some unique places on earth.

## Required
* [Maven] (https://maven.apache.org/download.cgi)
* [JDK 1.8] (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Optional: IDE - Eclipse, Intellij (Ultimate), NetBeans
* Connection to the internet.

## Usage 
1. Open console.
2. Go to directory where You have downloaded that repository. 
2. Type ```mvn jetty:run```
3. When server starts:
  - go to localhost:8080/weather to see weather for all 5 providede cities
  - go to localhost:8080/weather/city and replace city with any given city.
4. Terminate to stop app.

## Technology and logs
To check if App is working, go to the logINFO file, which should consist of some information about web-app.

Technolgies used in that project: 
- JavaEE, Jax-RS, Jersey, Jetty, JUnit, Mockito, Jadler, Gson, log4j. 

**Made by KR.**