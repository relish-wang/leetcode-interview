plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

// 该工程将 .java 与 .kt 源码混放在 src/main/kotlin 目录下，
// 而 Gradle 默认的 Java 源目录是 src/main/java，导致这些 Java 文件不会被 javac 编译。
// 这里将 Java 源目录也指向 src/main/kotlin，确保 Kotlin/Java 混合源码都能正确编译。
sourceSets {
    main {
        java.srcDirs("src/main/kotlin")
    }
}