plugins {
    id ("com.github.ben-manes.versions") version "0.38.0"
    application
    checkstyle
    id("org.sonarqube") version "6.0.1.5171"
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
application {
    mainClass = "hexlet.code.App"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.3")
    implementation("com.fasterxml.jackson.core:jackson-core:2.18.3")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.3")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }


sonar {
    properties {
        property("sonar.projectKey", "e4riya_java-project-71")
        property("sonar.organization", "e4riya")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
