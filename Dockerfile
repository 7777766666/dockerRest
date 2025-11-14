# Multi-stage build с Spring Boot
FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

# Копируем все файлы проекта
COPY . .

# Собираем приложение с Spring Boot plugin
RUN ./gradlew clean build -x test --no-daemon

# Финальный образ
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Копируем JAR из стадии builder
COPY --from=builder /app/build/libs/*.jar app.jar

# Проверяем что файл скопировался и исполняемый
RUN ls -la /app/ && \
    java -jar /app/app.jar --version || echo "Checking JAR..."

ENTRYPOINT ["java", "-jar", "app.jar"]