# my-java-reactive-microservice-mongodb
My Java Reactive Microservice with MongoDB

### Prerequisites
- JDK v17
- Maven v3.8.4

### Build
setjdk17
./mvnw clean package
./mvnw clean test

### Run
mongod --dbpath $MONGODB_DATA/db --auth
mongo -u local -p local 127.0.0.1:27017 --authenticationDatabase admin
use local
show collections
use javarx
db.javarx.count()
db.javarx.find()

./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
./mvnw spring-boot:run -Dspring-boot.run.profiles=docker

### Api documentation
http://localhost:8027/java-reactive-microservice-mongodb/webjars/swagger-ui/index.html

### Play
curl -I http://localhost:8027/java-reactive-microservice-mongodb/v1/version

##### Create
curl -X 'POST' \
  'http://localhost:8027/java-reactive-microservice-mongodb/v1/save' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "version": "JDK 17"
}'

##### Read
curl -X 'GET' \
'http://localhost:8027/java-reactive-microservice-mongodb/v1/findAll' \
-H 'accept: */*'

