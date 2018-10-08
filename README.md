Web-Frameworks Class at FHNW
===
Start MongoDB with:
```bash
docker-compose.exe -f src/main/docker/mongodb.yml up
````

Build the jar and run:
```bash
./mvnw clean package -DskipTests
java -jar target/flashcard-mvc-0.0.1-SNAPSHOT.jar
```

Visit: [localhost:8080/questionnaires](http://localhost:8080/questionnaires)

