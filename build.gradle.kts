import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent


plugins {
    id("java")
    application
}

application {
    mainClass.set("org.example.hexlet.HelloWorld")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Версии зависимостей могут отличаться
    // Здесь мы сразу подключаем зависимости,
    // которые понадобятся во время обучения
    implementation("io.javalin:javalin:6.1.3")
    implementation("io.javalin:javalin-rendering:6.1.3")

    implementation("org.slf4j:slf4j-simple:2.0.17")

    implementation("gg.jte:jte:3.1.9")
    implementation ("net.datafaker:datafaker:2.3.1")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")

    implementation ("org.apache.commons:commons-text:1.9")
    implementation ("commons-codec:commons-codec:1.18.0")
    implementation ("com.google.guava:guava:31.1-jre")
    implementation("com.h2database:h2:2.2.220")
    implementation("com.zaxxer:HikariCP:5.0.1")


    compileOnly ("org.projectlombok:lombok:1.18.24")
    annotationProcessor ("org.projectlombok:lombok:1.18.24")
    implementation ("org.slf4j:slf4j-api:2.0.16")
    implementation ("org.slf4j:slf4j-simple:2.0.16")

    implementation("jakarta.servlet:jakarta.servlet-api:6.1.0")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.2")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:3.27.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}