# Usamos una imagen oficial de Maven con OpenJDK
FROM maven:3.9.6-eclipse-temurin-21

# Definimos el directorio de trabajo
WORKDIR /app

# Copiamos el código fuente al contenedor
COPY . .

# Construimos el proyecto dentro del contenedor
RUN mvn clean package

# Copiamos el .jar generado
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
