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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

dependencies {
    //Kotlin
    implementation(Dependencies.core_ktx_library)
    implementation(Dependencies.lifecycle_runtime_ktx)

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
}