import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}

repositories {
    jcenter()
}

dependencies {
    compile("com.github.mvysny.karibudsl:karibu-dsl-v10:0.5.3")

    compile("ch.qos.logback:logback-classic:1.2.3")
    compile("org.slf4j:slf4j-api:1.7.25")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}