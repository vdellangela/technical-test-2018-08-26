# VDELLANGELA - Technical assessment

The purpose of this application is to return the number of cab trips given a list of medallions and a date


## Setup

Requirements are having Java, MySQL and Maven installed.
Update the src/main/resources/application.properties file with your database details.
Run the below command to download all the dependencies and generate a jar:
```
maven clean install
```
And run this command to start the application:
```
java -jar target/cab-0.0.1-SNAPSHOT.jar
```

The application provides a REST API GET http://localhost:8080/cabs that given the following parameters:
- List of medallions (List<String>)
- Date (YYYY-MM-DD)
- Cache (optional Boolean, default is TRUE)
will return the number of trips for each of them.

Example: http://localhost:8080/cabs?medallion=D7D598CD99978BD012A87A76A7C891B7&date=2013-12-01&medallion=5455D5FF2BD94D10B304A15D4B7F2735&cache=false


## Testing

You can run the command line mvn test in order to run the junit tests.
