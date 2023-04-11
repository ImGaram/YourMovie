object Dependency {
    object GradlePlugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
        const val HILT_ANDROID_GRADLE = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt}"
    }

    object AndroidX {
        const val KOTLIN_CORE = "androidx.core:core-ktx:${Versions.Kotlin}"
        const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifeCycle}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.Fragment}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ActivityCompose}"
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.Compose}"
        const val COMPOSE_UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.Material}"
        const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${Versions.NavigationCompose}"
    }

    object Coil {
        const val COIL = "com.github.skydoves:landscapist-coil:${Versions.Coil}"
    }

    object Room {
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.Room}"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.Room}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.Room}"
        const val ROOM_COMPILER_KAPT = "androidx.room:room-compiler:${Versions.Room}"
    }

    object Hilt {
        const val HILT_ANDROID_GRADLE = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt}"
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.Hilt}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.Hilt}"
        const val HILT_NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.HiltNavigationCompose}"
    }

    object Retrofit {
        const val RETROFIT_KT = "com.squareup.retrofit2:retrofit:${Versions.Retrofit}"
        const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.Gson}"
    }

    object Okhttp {
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object LifeCycle {
        const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LifeCycleVersion}"
        const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LifeCycleVersion}"
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