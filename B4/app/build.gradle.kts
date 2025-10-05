plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.b4"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.b4"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation("androidx.activity:activity:1.8.0")

    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(libs.constraintlayout)
    implementation(libs.palette)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}