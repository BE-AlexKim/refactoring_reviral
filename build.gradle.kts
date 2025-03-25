plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("kapt") version "1.9.25"
	kotlin("plugin.jpa") version "1.9.25"
}

group = "kr.reviral.website"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		this.languageVersion
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// QueryDSL 추가
	implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
	kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
	kapt("jakarta.annotation:jakarta.annotation-api")
	kapt("jakarta.persistence:jakarta.persistence-api")
	runtimeOnly("com.mysql:mysql-connector-j")

	// Kotlin Logging
	implementation("io.github.oshai:kotlin-logging-jvm:5.1.1")

	// Spring Mail
	implementation("org.springframework.boot:spring-boot-starter-mail")

	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
		jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
	}
}

val generated = file("src/main/generated")

tasks.withType<JavaCompile> {
	options.generatedSourceOutputDirectory.set(generated)
}

sourceSets {
	main {
		kotlin {
			srcDirs += generated
		}
	}
}

tasks.named("clean") {
	doLast {
		generated.deleteRecursively()
	}
}

kapt {
	generateStubs = true
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
