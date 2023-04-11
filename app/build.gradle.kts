import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.example.yourmovie"
    compileSdk = Versions.CompileSdk

    defaultConfig {
        applicationId = "com.example.yourmovie"
        minSdk = Versions.MinSdk
        targetSdk = Versions.TargetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "API_KEY", getApiKey("API_KEY"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}

dependencies {
    // room
    implementation(Dependency.Room.ROOM_KTX)
    implementation(Dependency.Room.ROOM_RUNTIME)
    annotationProcessor(Dependency.Room.ROOM_COMPILER)
    kapt(Dependency.Room.ROOM_COMPILER_KAPT)

    // hilt
    implementation(Dependency.Hilt.HILT_ANDROID)
    implementation(Dependency.Hilt.HILT_NAVIGATION_COMPOSE)
    kapt(Dependency.Hilt.HILT_ANDROID_COMPILER)

    // coil
    implementation(Dependency.Coil.COIL)

    // retrofit
    implementation(Dependency.Retrofit.RETROFIT_KT)
    implementation(Dependency.Retrofit.RETROFIT_GSON_CONVERTER)
    implementation(Dependency.Okhttp.OKHTTP)
    implementation(Dependency.Okhttp.OKHTTP_LOGGING_INTERCEPTOR)

    implementation(Dependency.AndroidX.KOTLIN_CORE)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependency.AndroidX.FRAGMENT_KTX)
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.Compose.COMPOSE_UI)
    implementation(Dependency.Compose.COMPOSE_UI_PREVIEW)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    implementation(Dependency.Compose.COMPOSE_NAVIGATION)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.TEST_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO)
    androidTestImplementation(Dependency.AndroidTest.COMPOSE_JUNIT)
    debugImplementation(Dependency.Debug.COMPOSE_TOOLING)
    debugImplementation(Dependency.Debug.COMPOSE_MANIFEST)

    implementation(Dependency.LifeCycle.LIFECYCLE_VIEWMODEL)
    implementation(Dependency.LifeCycle.LIFECYCLE_LIVEDATA)
}