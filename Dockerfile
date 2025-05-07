FROM eclipse-temurin:17-jdk-alpine

# Instalamos bash y Maven
RUN apk add --no-cache bash maven

# Establecemos directorio de trabajo
WORKDIR /app

# Copiamos el proyecto completo
COPY . .

# Compilamos la app sin tests
RUN mvn clean package -DskipTests

# Exponemos el puerto de Spring Boot
EXPOSE 8080

# Ejecutamos la app
CMD ["java", "-jar", "target/*.jar"]
