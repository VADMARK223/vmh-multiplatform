import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.vadmark223"
version = "1.0-SNAPSHOT"


kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.desktop.currentOs)
                implementation("org.apache.logging.log4j:log4j-api:2.13.3")
                implementation("org.apache.logging.log4j:log4j-core:2.13.3")
                implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.13.3")
                implementation("org.postgresql:postgresql:42.3.4")
                implementation("org.jetbrains.exposed:exposed-core:0.38.1")
                implementation("org.jetbrains.exposed:exposed-dao:0.38.1")
                implementation("org.jetbrains.exposed:exposed-jdbc:0.38.1")
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "vmh-multiplatform"
            packageVersion = "1.0.0"
        }
    }
}
