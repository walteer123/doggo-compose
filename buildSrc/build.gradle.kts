plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {

    implementation("com.android.tools.build:gradle:7.0.0")

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")

    implementation(kotlin("script-runtime"))
}