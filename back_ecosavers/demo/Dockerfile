
FROM openjdk:21


WORKDIR /app

RUN mvn clean package
COPY target/demo.jar app.jar


EXPOSE 8080


CMD ["java", "-jar", "app.jar"]

