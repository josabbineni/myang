# Student Demo 
Demo Project for SpringBoot Angular Docker showing CRUD on Student details

Student Spring Angular
A demo of my Spring boot + Angular + Postgresql

Prerequisites on development instance
JDK8 , Node/NPM,

Technologies
* Spring Boot
* Maven
* Spring Data JPA
* PostgreSQL (Production, Development)
* H2 Database Engine (Test)
* Docker
* Docker Compose
* Angular5

# Deploy

# Build the spring project
student-rest/mvn package
# Build the angular project
* student-app/npm install
* student-app/ng build --prod


# Run in container
docker-compose up --build

# Test
http://localhost or http://0.0.0.0 or http://docker_machine_ip

docker-machine ip on windows /mac gives ip
