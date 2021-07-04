import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:1.5.0"
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.3.0"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.3.0"
    }

    object Ktor {
        const val ANDROID = "io.ktor:ktor-client-android:1.5.0"
        const val SERIALIZATION = "io.ktor:ktor-client-serialization:1.5.0"
        const val LOGGING = "io.ktor:ktor-client-logging-jvm:1.5.0"
    }

    object Kotlin {
        const val SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"
    }

    object Koin {
        object Kotlin {
            const val CORE = "io.insert-koin:koin-core:3.1.2"
            const val TEST = "io.insert-koin:koin-test:3.1.2"
        }

        object JUnit {
            const val JUNIT4 = "io.insert-koin:koin-test-junit4:3.1.2"
            const val JUNIT5 = "io.insert-koin:koin-test-junit5:3.1.2"
        }

        object Android {
            const val MAIN = "io.insert-koin:koin-android:3.1.2"
            const val JAVA_COMPAT = "io.insert-koin:koin-android-compat:3.1.2"
            const val WORK_MANAGER = "io.insert-koin:koin-androidx-workmanager:3.1.2"
            const val COMPOSE = "io.insert-koin:koin-androidx-compose:3.1.2"
        }

        object Ktor {
            const val MAIN = "io.insert-koin:koin-ktor:3.1.2"
            const val SLF4J = "io.insert-koin:koin-logger-slf4j:3.1.2"
        }
    }

    object Test {
        object Unit {
            const val JUNIT = "junit:junit:4.+"
        }

        object Integration {
            const val JUNIT = "androidx.test.ext:junit:1.1.2"
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    fun DependencyHandlerScope.common() {
        "implementation"(Kotlin.SERIALIZATION)
        "implementation"(AndroidX.CORE)
    }

    fun DependencyHandlerScope.commonUnitTest() {
        "androidTestImplementation"(Test.Unit.JUNIT)
    }

    fun DependencyHandlerScope.commonNetwork() {
        "implementation"(Ktor.ANDROID)
        "implementation"(Ktor.SERIALIZATION)
        "implementation"(Ktor.LOGGING)
    }

    fun DependencyHandlerScope.commonIntegrationTest() {
        "androidTestImplementation"(Test.Integration.JUNIT)
        "androidTestImplementation"(Test.Integration.ESPRESSO_CORE)
    }

}
