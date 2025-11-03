# ---- Build stage ----
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy Maven wrapper + pom first to cache dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -q -DskipTests dependency:go-offline

# Copy the source code and build
COPY src ./src
RUN ./mvnw -q -DskipTests package

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Render sets the PORT automatically (e.g., 10000+)
ENV PORT=8080
EXPOSE 8080

# Copy the packaged JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Start the app
ENTRYPOINT ["java","-Dserver.port=${PORT}","-Djava.net.preferIPv4Stack=true","-jar","/app/app.jar"]
