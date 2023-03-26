object Dependency {
    object GradlePlugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    }

    object AndroidX {
        const val KOTLIN_CORE = "androidx.core:core-ktx:${Versions.Kotlin}"
        const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifeCycleRuntime}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ActivityCompose}"
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.Compose}"
        const val COMPOSE_UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.Material}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.Junit}"
    }

    object AndroidTest {
        const val TEST_JUNIT = "androidx.test.ext:junit:${Versions.TestJunit}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Espresso}"
        const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.Compose}"
    }

    object Debug {
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Compose}"
        const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.Compose}"
    }
}