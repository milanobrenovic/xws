# How to run this project with docker
1. Change `application.properties` file, the line `spring.datasource.url=jdbc:postgresql://localhost:5432/postgres` into `spring.datasource.url=jdbc:postgresql://postgres:5432/Xws`
2. `docker-compose build --no-cache`
3. `docker-compose up --force-recreate`
