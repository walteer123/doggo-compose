import Dependencies.common
import Dependencies.commonIntegrationTest
import Dependencies.commonNetwork
import Dependencies.commonUnitTest

plugins {
    id("com.android.application")
    id("kotlin-android")
    id ("kotlinx-serialization")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "com.walter.doggo_compose"
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName  = "1.0"

        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.5.10"
        kotlinCompilerExtensionVersion = "1.0.0-beta09"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    common()
    commonNetwork()

    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.Google.MATERIAL)

    implementation(Dependencies.Koin.Kotlin.CORE)

    implementation(Dependencies.Koin.Android.MAIN)
    implementation(Dependencies.Koin.Android.JAVA_COMPAT)
    implementation(Dependencies.Koin.Android.WORK_MANAGER)
    implementation(Dependencies.Koin.Android.COMPOSE)
    implementation(Dependencies.Koin.Android.COMPOSE)

    implementation(Dependencies.Koin.Ktor.MAIN)
    implementation(Dependencies.Koin.Ktor.SLF4J)

    implementation(project(Modules.Network))

    testImplementation(Dependencies.Koin.Kotlin.TEST)
    testImplementation(Dependencies.Koin.JUnit.JUNIT4)
    testImplementation("io.insert-koin:koin-test:3.1.2")
    commonUnitTest()
    commonIntegrationTest()
}