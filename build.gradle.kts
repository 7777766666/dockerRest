plugins {
	java
	id("org.springframework.boot") version "3.2.5"  // ⚠️ Используем стабильную версию
	id("io.spring.dependency-management") version "1.1.7"
	id("application")  // ⚠️ Добавляем application plugin
}

group = "tesla"
version = "0.0.2-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}
application {
	mainClass.set("tesla.docker.DockerApplication")  // ⚠️ Укажите ваш главный класс
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.postgresql:postgresql")
}
