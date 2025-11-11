# Используем базовый образ
FROM eclipse-temurin:17-jdk-alpine AS GRADLE_BUILD

# Рабочая директория
WORKDIR /app

# Копируем файлы
COPY gradle/ gradle/
COPY gradlew .
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src/ src/

# Даем права и собираем
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# Многоступенчатая сборка (опционально)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=GRADLE_BUILD /app/build/libs/docker-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт
EXPOSE 8888

# Команда запуска
CMD ["java", "-jar", "app.jar"]