import org.jetbrains.gradle.ext.settings
import org.jetbrains.gradle.ext.taskTriggers

plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.sonarqube") version "5.0.0.4638"
	id("org.openapi.generator") version "7.4.0"
	id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.8"
}

group = "com.dreamscore"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

sonar {
	properties {
		property("sonar.projectKey", "dreamscore-platform-backend")
		property("sonar.organization", "dreamscore")
		property("sonar.host.url", "https://sonarcloud.io")
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

val mapstructVersion = "1.5.5.Final"
val oktaSpringBootStarterVersion = "3.0.6"
val jacksonDatabindNullableVersion = "0.2.6"
val springdocOpenapiStarterWebmvcUiVersion = "2.4.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	implementation("com.okta.spring:okta-spring-boot-starter:$oktaSpringBootStarterVersion")
	implementation("org.openapitools:jackson-databind-nullable:$jacksonDatabindNullableVersion")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocOpenapiStarterWebmvcUiVersion")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
}

openApiGenerate {
	generatorName.set("spring")
	inputSpec.set("${projectDir}/src/main/resources/api/dreamscore.yaml")
	outputDir.set(layout.buildDirectory.dir("generated/openapi").get().asFile.absolutePath)
	apiPackage.set("${group}.backend.api")
	invokerPackage.set("${group}.backend.handler")
	modelPackage.set("${group}.backend.model")
	modelNameSuffix.set("Dto")
	configOptions.set(mapOf(
		"delegatePattern" to "true",
		"useSpringBoot3" to "true",
		"useSpringController" to "true",
	))
}

idea.project.settings {
	taskTriggers {
		beforeBuild(tasks.getByName("openApiGenerate"))
		beforeRebuild(tasks.getByName("openApiGenerate"))
		afterSync(tasks.getByName("openApiGenerate"))
		beforeSync(tasks.getByName("openApiGenerate"))
	}
}

sourceSets {
	main {
		java {
			srcDir(layout.buildDirectory.file("generated/openapi/src/main/java").get().asFile)
		}
	}
}

tasks.withType<JavaCompile> {
	dependsOn("openApiGenerate")
	options.compilerArgs.add("-parameters")
}

springBoot {
	mainClass.set("${group}.backend.Application")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
