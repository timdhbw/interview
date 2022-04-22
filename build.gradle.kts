import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
    id("org.springframework.boot") version "2.5.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    kotlin("plugin.jpa") version "1.5.31"
    id("org.flywaydb.flyway") version "5.0.7"
    id("org.openapi.generator") version "5.3.0"
    kotlin("kapt") version "1.3.72"
}

group = "com.signicat"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mapstruct:mapstruct:1.5.0.RC1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("com.nimbusds:nimbus-jose-jwt:9.15.2")
    implementation("org.flywaydb:flyway-core")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.springframework.security:spring-security-test")
    kapt("org.mapstruct:mapstruct-processor:1.5.0.RC1")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

kapt {
    arguments {
        // Set Mapstruct Configuration options here
        // https://kotlinlang.org/docs/reference/kapt.html#annotation-processor-arguments
        // https://mapstruct.org/documentation/stable/reference/html/#configuration-options
        arg("mapstruct.defaultComponentModel", "spring")
        arg("mapstruct.unmappedTargetPolicy", "ERROR")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }

    val spec = "$rootDir/src/main/resources/templates/openapi.yml"
    val generatedSourcesDir = "$rootDir/src/main/kotlin/"

    openApiGenerate {
        generatorName.set("kotlin-spring")
        inputSpec.set(spec)
        outputDir.set(generatedSourcesDir)
        apiPackage.set("com.signicat.interview.gen.api")
        modelPackage.set("com.signicat.interview.gen.api.model")
        modelNameSuffix.set("Dto")
        configOptions.set(
            mapOf(
                "delegatePattern" to "true",
                "title" to "OpenApiApi",
                "interfaceOnly" to "true",
                "sourceFolder" to ""
            )
        )
    }

//    openApiGenerate {
//        generatorName.set("asciidoc")
//        inputSpec.set(spec)
//        outputDir.set("$rootDir/doku")
//    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
