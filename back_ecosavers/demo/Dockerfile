# Usamos OpenJDK como base
FROM openjdk:21

# Instalamos Maven dentro del contenedor
RUN apt-get update && apt-get install -y maven

# Definimos el directorio de trabajo
WORKDIR /app

# Copiamos el código fuente al contenedor
COPY . .

# Construimos el proyecto
RUN mvn clean package

# Copiamos el .jar generado
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
