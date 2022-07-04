## CALENDAR-API

#### Health check
```
http://localhost:8070/actuator/health
```
#### Swagger
```
http://localhost:8070/swagger-ui.html
```

<details>
  <summary>Initial instructions</summary>

#### Build
```
./gradlew clean build      
```
#### Local MongoDB
```
docker run -d -p 27017:27017 --name calendar-mongo-local mongo:4.0.10
``` 
#### Local boot
```
./gradlew bootRun --args="--spring.profiles.active=local  
```
#### Creating initial data
```
sudo chmod +x ./create-initial-data.sh
./create-initial-data.sh
```
#### Docker
```
docker compose up
```

</details>

<details>
  <summary>Other details</summary>

#### Time format
```
24-hour clock
```
#### Check calendar avaliability
```
http://localhost:8070/availability?personName=Interviewer1&dayOfWeek=FRIDAY
```

</details>