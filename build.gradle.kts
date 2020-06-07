buildscript {

    repositories {
        google()
        mavenLocal()
        gradlePluginPortal()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        jcenter()
    }

    dependencies {
        classpath(Depends.Classpath.gradle)
        classpath(Depends.Classpath.kotlinGradlePlugin)
        classpath(Depends.Classpath.serialization)
    }
}

subprojects {
    repositories {
        google()
        gradlePluginPortal()
    }
}

