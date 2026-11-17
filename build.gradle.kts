import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "2.2.20"
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.20"
    id("org.jetbrains.compose") version "1.9.0"
}

kotlin { jvmToolchain(17) }

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.materialIconsExtended)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.10.2")
}

compose.desktop {
    application {
        mainClass = "com.example.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Exe)
            packageName = "Cognitive Circuit"
            packageVersion = "1.0.0"
            description = "6-node cognitive feedback loop with timer auto-switching and voice affirmations"
            vendor = "Cognitive Circuit"
            modules("java.prefs", "jdk.unsupported")

            windows {
                iconFile.set(project.file("packaging/icon.ico"))
                menuGroup = "Cognitive Circuit"
                shortcut = true
                dirChooser = true
                perUserInstall = true
                upgradeUuid = "6f1d3a52-8c7e-4b1a-9a0e-3c5d7b2e4f10"
            }
        }
    }
}
