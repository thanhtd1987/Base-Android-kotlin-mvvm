/*
 * Copyright (c) Funworld
 */

import java.text.SimpleDateFormat
import java.util.Calendar

plugins {
    id(Plugins.androidApp)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinApt)
    id(Plugins.hilt)
    id(Plugins.kotlin_kapt)
    id(Plugins.kotlinParcelable)
    id(Plugins.checkDependencyUpdates) version (Versions.check_dependency_updates)
}

buildscript {
    apply(from = "../buildSrc/ktlint.gradle.kts")
}

android {
    compileSdk = Versions.compile_sdk_version

    flavorDimensions.add("default")

    defaultConfig {
        applicationId = "com.funworld.mvvm_architecture"
        minSdk = Versions.min_sdk_version
        targetSdk = Versions.target_sdk_version
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "com.funworld.mvvm_architecture.app.CustomTestRunner"
    }

    productFlavors {
        create("DEV") {
            applicationIdSuffix = ".dev"
            versionCode = 1
            versionName = "1.0.0"

            resValue("string", "app_name", "Android Base")
            buildConfigField("String", "END_POINT", "\"https://api-dev.neo-lab.com/v1/\"")
        }

        create("PROD") {
            versionCode = 1
            versionName = "1.0.0"

            resValue("string", "app_name", "Android Base")
            buildConfigField("String", "END_POINT", "\"https://api-dev.neo-lab.com/v1/\"")
        }

        applicationVariants.all {
            // Fix room compiler conflicts dependencies
            runtimeConfiguration.exclude("com.intellij", "annotations")

            outputs.forEach { output ->
                if (output is com.android.build.gradle.internal.api.BaseVariantOutputImpl) {
                    output.outputFileName =
                        "Funworld_${name}_${versionName}_${this.versionCode}.${output.outputFile.extension}"
                }
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                file("proguard-rules.pro"),
                file("androidx-proguard-rules.pro")
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    packagingOptions {
        resources.excludes.add("META-INF/DEPENDENCIES")
        resources.excludes.add("META-INF/LICENSE")
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/license.txt")
        resources.excludes.add("META-INF/NOTICE")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/ASL2.0")
        resources.excludes.add("META-INF/*.kotlin_module")
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }

    sourceSets {
        sourceSets {
            val sharedTestDir = "src/sharedTest/java"
            getByName("androidTest").java.srcDirs(sharedTestDir)
            getByName("test").java.srcDirs(sharedTestDir)
        }
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

kapt {
    useBuildCache = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // Kotlin
    implementation(Dependencies.kotlin_stdlib)
    // App compat & design
    implementation(Dependencies.support_app_compat)
    implementation(Dependencies.support_core)
    implementation(Dependencies.support_design)
    implementation(Dependencies.constraint_layout)
    // Coroutines
    implementation(Dependencies.coroutines_core)
    implementation(Dependencies.coroutines_android)
    // Room
    implementation(Dependencies.room_runtime)
    implementation(Dependencies.room_compiler)
    implementation(Dependencies.room_ktx)
    // Retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_converter_gson)
    // Okhttp
    implementation(Dependencies.ok_http)
    implementation(Dependencies.ok_http_logging)
    // Hilt
    implementation(Dependencies.hilt)
    implementation(Dependencies.hilt_compiler)
    // Glide
    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glide_compiler)
    kapt(Dependencies.glide_compiler)
    // Leak canary
    debugImplementation(Dependencies.leak_canary)
    // Timber
    implementation(Dependencies.timber)
    // KTX
    implementation(Dependencies.support_core_ktx)
    implementation(Dependencies.view_model_ktx)
    implementation(Dependencies.live_data_ktx)
    implementation(Dependencies.fragment_ktx)

    // LocalDate, LocalDateTime
    coreLibraryDesugaring(Dependencies.desugar_jdk_libs)

    // Unit Test
    implementLocalUnitTest()
    implementInstrumentationUnitTest()
}
