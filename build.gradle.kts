// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Dependency.GradlePlugins.ANDROID_APPLICATION) version Versions.GradleAndroid apply false
    id (Dependency.GradlePlugins.ANDROID_LIBRARY) version Versions.GradleAndroid apply false
    id (Dependency.GradlePlugins.KOTLIN_ANDROID) version Versions.Kotlin apply false
}