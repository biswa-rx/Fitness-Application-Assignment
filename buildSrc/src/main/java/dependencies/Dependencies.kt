package dependencies

object Dependencies {
    val core_ktx_library = "androidx.core:core-ktx:${Versions.ktx_version}"
    val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtime_ktx}"
    val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_compiler_version}"
}