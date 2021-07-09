import Dependencies.common
import Dependencies.commonIntegrationTest
import Dependencies.commonNetwork
import Dependencies.commonUnitTest

plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id ("kotlinx-serialization")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 23
        targetSdk = 30
        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(Dependencies.Koin.Kotlin.CORE)

    implementation(Dependencies.Koin.Android.MAIN)
    implementation(Dependencies.Koin.Android.JAVA_COMPAT)
    implementation(Dependencies.Koin.Android.WORK_MANAGER)
    implementation(Dependencies.Koin.Android.COMPOSE)
    implementation(Dependencies.Koin.Android.COMPOSE)

    implementation(Dependencies.Koin.Ktor.MAIN)
    implementation(Dependencies.Koin.Ktor.SLF4J)

    testImplementation(Dependencies.Koin.Kotlin.TEST)
    testImplementation(Dependencies.Koin.JUnit.JUNIT4)
    testImplementation("io.insert-koin:koin-test:3.1.2")
    commonUnitTest()
    commonIntegrationTest()
}