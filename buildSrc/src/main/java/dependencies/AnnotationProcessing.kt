package dependencies

object AnnotationProcessing {
    val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt_version}"
    val hilt_android_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler_version}"
}