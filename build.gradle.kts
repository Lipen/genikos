import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.github.Lipen"

plugins {
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.allopen") version "1.7.20"
    id("fr.brouillard.oss.gradle.jgitver") version "0.9.1"
    id("com.github.ben-manes.versions") version "0.44.0"
    id("me.champeau.jmh") version "0.6.8"
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(kotlin("bom")))
    implementation(kotlin("stdlib-jdk8"))
    // implementation(kotlin("reflect"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

java {
    withSourcesJar()
    withJavadocJar()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

jgitver {
    strategy("MAVEN")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven(url = "$buildDir/repository")
    }
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

jmh {
    // includes.set(listOf("Sorting"))
    jmhVersion.set("1.36")
    warmupIterations.set(1)
    iterations.set(10)
    timeOnIteration.set("1s")
}

tasks.wrapper {
    gradleVersion = "7.5.1"
    distributionType = Wrapper.DistributionType.ALL
}

defaultTasks("clean", "build")
