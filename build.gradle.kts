plugins {
    java
    application
}

group = "org.javai"
version = "0.1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.javai:javai-newsroom:0.1.0-SNAPSHOT")
    testImplementation(testFixtures("org.javai:javai-newsroom:0.1.0-SNAPSHOT"))
    testImplementation("org.javai:punit-junit5:0.4.0")
    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass = "org.javai.org.Main"
}

tasks.test {
    useJUnitPlatform {
        excludeTags("punit-experiment")
    }
    filter {
        excludeTestsMatching("*RelevanceClassificationTest*")
        isFailOnNoMatchingTests = false
    }
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}

// Probabilistic tests — sample-level failures are expected; the aggregate
// statistical verdict determines pass/fail, not individual samples.
tasks.register<Test>("probabilisticTest") {
    description = "Runs probabilistic tests (sample failures do not fail the build)"
    group = "verification"
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
    useJUnitPlatform()
    filter {
        includeTestsMatching("*RelevanceClassificationTest*")
    }
    ignoreFailures = true
    environment("ANTHROPIC_API_KEY", System.getenv("ANTHROPIC_API_KEY") ?: "")
    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}

val stateFile = rootProject.file("newsroom/data/state.json").absolutePath
val configDir = rootProject.file("newsroom/config").absolutePath
val siteDir = layout.buildDirectory.dir("site").get().asFile.absolutePath

tasks.register<JavaExec>("fetchNews") {
    dependsOn("classes")
    mainClass = "org.javai.org.Main"
    classpath = sourceSets["main"].runtimeClasspath
    args = mutableListOf("fetch", "--config=$configDir", "--state=$stateFile")
    if (project.hasProperty("tiers")) {
        args("--tiers=${project.property("tiers")}")
    }
    environment("ANTHROPIC_API_KEY", System.getenv("ANTHROPIC_API_KEY") ?: "")
}

tasks.register<JavaExec>("generateFeed") {
    dependsOn("classes")
    mainClass = "org.javai.org.Main"
    classpath = sourceSets["main"].runtimeClasspath
    args = listOf("generate", "--state=$stateFile", "--output=$siteDir")
}
