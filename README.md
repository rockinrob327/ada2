# Cognitive Circuit — Windows desktop build

Compose Multiplatform (Desktop) port of the Android app. Same UI, timer, shuffle and
affirmation editing; Windows-native replacements for the Android-only parts:

| Android                    | Windows version                              |
|----------------------------|----------------------------------------------|
| SharedPreferences          | java.util.prefs (Windows registry)           |
| TextToSpeech               | Built-in Windows SAPI voices via PowerShell  |
| ToneGenerator              | Generated 120 ms chime                       |
| Toast / Clipboard          | In-app toast / AWT clipboard                 |
| Foreground service         | Removed (desktop app keeps running)          |

## Build
1. `winget install EclipseAdoptium.Temurin.17.JDK`
2. `winget install Gradle.Gradle`
3. For the .msi: `winget install WiXToolset.WiXToolset` (WiX 3.x)
4. Double-click `build-installer.bat`

Output: `build\compose\binaries\main\msi\Cognitive Circuit-1.0.0.msi`
(or the portable `build\compose\binaries\main\app\Cognitive Circuit\Cognitive Circuit.exe`).

`run.bat` launches it directly for testing.
