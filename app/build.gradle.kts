import dependencies.Versions
import dependencies.Application
import dependencies.Dependencies
import dependencies.DebugDependencies
import dependencies.SupportDependencies
import dependencies.AndroidTestDependencies
import dependencies.TestDependencies
import dependencies.Java
import dependencies.AnnotationProcessing
import dependencies.Kotlin

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = Application.id
    compileSdk = Versions.compile_sdk

    defaultConfig {
        applicationId = Application.id
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = Application.version_code
        versionName = Application.version_name

        testInstrumentationRunner = AndroidTestDependencies.instrumentation_runner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Java.java_version
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Kotlin.kotlin_compiler_extension_version
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    //Kotlin
    implementation(Dependencies.core_ktx_library)
    implementation(Dependencies.lifecycle_runtime_ktx)

    //Dependencies
    implementation (Dependencies.hilt_android)

    //Annotation processing
    kapt (AnnotationProcessing.hilt_compiler)

    kapt ("androidx.hilt:hilt-compiler:1.1.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    //Support
    implementation(SupportDependencies.activity_compose)
    implementation(platform(SupportDependencies.compose_bom))
    implementation(SupportDependencies.compose_ui_library)
    implementation(SupportDependencies.compose_ui_graphics)
    implementation(SupportDependencies.ui_tooling_preview)
    implementation(SupportDependencies.material3_library)

    //Unit Test
    testImplementation(TestDependencies.junit_library)

    //Instrumentation Test - UI test
    androidTestImplementation(AndroidTestDependencies.ext_junit)
    androidTestImplementation(AndroidTestDependencies.espresso_core)
    androidTestImplementation(platform(AndroidTestDependencies.compose_bom))
    androidTestImplementation(AndroidTestDependencies.ui_test_junit4)

    //Debug
    debugImplementation(DebugDependencies.ui_tooling)
    debugImplementation(DebugDependencies.ui_test_manifest)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")



    //Compose Destination
    implementation("io.github.raamcosta.compose-destinations:core:1.9.52")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.9.52")

    //Compose Dependency
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.33.1-alpha")
    implementation ("androidx.compose.material:material-icons-extended:1.6.0-alpha04")
}