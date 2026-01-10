import java.util.Properties
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

// Load optional signing properties from local.properties (kept out of VCS)
val versionPropsFile = rootProject.file("local.properties")
val localProps = Properties().apply {
    if (versionPropsFile.exists()) versionPropsFile.inputStream().use { load(it) }
}
val releaseStoreFile = localProps.getProperty("release.storeFile")
val releaseStorePassword = localProps.getProperty("release.storePassword")
val releaseKeyAlias = localProps.getProperty("release.keyAlias")
val releaseKeyPassword = localProps.getProperty("release.keyPassword")

val currentVersionCode = (localProps.getProperty("VERSION_CODE") ?: "1").toInt()
val currentVersionName = localProps.getProperty("VERSION_NAME") ?: "1.0.0"

// Version bumping task for release builds
tasks.register("bumpVersion") {
    doLast {
        val newVersionCode = currentVersionCode + 1

        val parts = currentVersionName.split(".")
        var major = parts[0].toInt()
        var minor = parts[1].toInt()
        var patch = parts[2].toInt()

        patch++
        if (patch >= 10) {
            patch = 0
            minor++
        }
        if (minor >= 11) {
            minor = 0
            major++
        }

        val newVersionName = "$major.$minor.$patch"

        println(">>> Bumped versionName: $currentVersionName → $newVersionName")
        println(">>> Bumped versionCode: $currentVersionCode → $newVersionCode")

        // Save back
        localProps["VERSION_CODE"] = newVersionCode.toString()
        localProps["VERSION_NAME"] = newVersionName
        FileOutputStream(versionPropsFile).use { localProps.store(it, null) }
    }
}

// Make release builds depend on version bump
tasks.matching { it.name == "assembleRelease" || it.name == "bundleRelease" }.configureEach {
    dependsOn("bumpVersion")
}

// Rename AAB outputs after bundleRelease completes
tasks.whenTaskAdded {
    if (name == "bundleRelease") {
        doLast {
            val date = SimpleDateFormat("yyMMdd.HHmm").format(Date())
            val bundleDir = file("${project.layout.buildDirectory.get()}/outputs/bundle/release")
            bundleDir.listFiles()?.filter { it.extension == "aab" }?.forEach { aabFile ->
                val newName = "portfolio-$date-v$currentVersionName-release.aab"
                val newFile = File(aabFile.parentFile, newName)
                if (aabFile.renameTo(newFile)) {
                    println(">>> Renamed AAB: ${aabFile.name} → $newName")
                } else {
                    println(">>> Failed to rename AAB: ${aabFile.name}")
                }
            }
        }
    }
}

android {
    namespace = "com.ymrabtiapps.portfolio"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ymrabtiapps.portfolio"
        minSdk = 24
        targetSdk = 35
        versionCode = currentVersionCode
        versionName = currentVersionName
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // Configure release signing if properties are provided
    if (
        releaseStoreFile != null &&
        releaseStorePassword != null &&
        releaseKeyAlias != null &&
        releaseKeyPassword != null
    ) {
        signingConfigs {
            create("release") {
                storeFile = file(releaseStoreFile)
                storePassword = releaseStorePassword
                keyAlias = releaseKeyAlias
                keyPassword = releaseKeyPassword
            }
        }
    }

    applicationVariants.all {
        val variant = this
        val variantName = variant.name
        val versionName = variant.versionName
        
        // Rename APK outputs
        outputs.all {
            val output = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            val date = SimpleDateFormat("yyMMdd.HHmm").format(Date())
            val arch = output.filters.find { 
                it.filterType == com.android.build.api.variant.FilterConfiguration.FilterType.ABI.name 
            }?.identifier ?: "universal"
            val newName = "portfolio-$date-v$versionName-$variantName-$arch.apk"
            output.outputFileName = newName
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Apply signing config if defined
            signingConfigs.findByName("release")?.let { signingConfig = it }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.coil.compose)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
