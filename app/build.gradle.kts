plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

dependencies {

    implementation(Dependency.AndroidX.KOTLIN_CORE)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.Compose.COMPOSE_UI)
    implementation(Dependency.Compose.COMPOSE_UI_PREVIEW)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.TEST_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO)
    androidTestImplementation(Dependency.AndroidTest.COMPOSE_JUNIT)
    debugImplementation(Dependency.Debug.COMPOSE_TOOLING)
    debugImplementation(Dependency.Debug.COMPOSE_MANIFEST)
}