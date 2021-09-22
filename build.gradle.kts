import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "com.sergiomartinrubio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:4.0.0")
    implementation("org.slf4j:slf4j-simple:1.7.31")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.4")
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("com.konghq:unirest-java:3.4.00")
    testImplementation("org.assertj:assertj-core:3.11.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}