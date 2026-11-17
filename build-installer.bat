@echo off
REM Builds the Windows installer (.msi) and a standalone app folder.
REM Requires: JDK 17+ and (for .msi/.exe) WiX Toolset 3.x on PATH.
where java >nul 2>nul || (echo JDK 17+ not found. Install: winget install EclipseAdoptium.Temurin.17.JDK & exit /b 1)
where gradle >nul 2>nul || (echo Gradle not found. Install: winget install Gradle.Gradle & exit /b 1)

if not exist gradlew.bat (
  echo Creating Gradle wrapper...
  call gradle wrapper --gradle-version 8.14.3 || exit /b 1
)

echo.
echo === Portable app (no installer tools needed) ===
call gradlew.bat createDistributable || exit /b 1
echo Portable app: build\compose\binaries\main\app\Cognitive Circuit\Cognitive Circuit.exe

echo.
echo === Installer (needs WiX 3.x: winget install WiXToolset.WiXToolset) ===
call gradlew.bat packageMsi
echo Installer: build\compose\binaries\main\msi\
