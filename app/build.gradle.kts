plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.foodorderapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.foodorderapp"
        minSdk = 24                      // Minimum Android version supported (Android 7.0 Nougat)
        targetSdk = 35                   // Targeting Android 13
        versionCode = 1                  // Internal version for updates
        versionName = "1.0"              // User-visible version string

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true               // Enables view binding for safer UI code
    }

    buildTypes {
        release {
            isMinifyEnabled = false      // Disable code shrinking for release build (change if needed)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)          // Support libraries for backward compatibility
    implementation(libs.material)           // Material Design components
    implementation(libs.activity)           // AndroidX Activity libraries
    implementation(libs.constraintlayout)   // ConstraintLayout for UI layout design

    testImplementation(libs.junit)          // Unit testing framework
    androidTestImplementation(libs.ext.junit)  // AndroidX JUnit extensions for instrumentation tests
    androidTestImplementation(libs.espresso.core) // UI testing framework (Espresso)
}
