plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.aydin.aistudio"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aydin.aistudio"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // Release signing is injected only by CI from GitHub Actions secrets.
            val ksPath = System.getenv("ANDROID_KEYSTORE_PATH")
            val ksPassword = System.getenv("ANDROID_KEYSTORE_PASSWORD")
            val keyAliasValue = System.getenv("ANDROID_KEY_ALIAS")
            val keyPasswordValue = System.getenv("ANDROID_KEY_PASSWORD")
            if (!ksPath.isNullOrBlank() && !ksPassword.isNullOrBlank()
                && !keyAliasValue.isNullOrBlank() && !keyPasswordValue.isNullOrBlank()) {
                signingConfig = signingConfigs.create("ciRelease") {
                    storeFile = file(ksPath)
                    storePassword = ksPassword
                    keyAlias = keyAliasValue
                    this.keyPassword = keyPasswordValue
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { compose = true }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.12.01"))
    implementation("androidx.activity:activity-compose:1.10.0")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
