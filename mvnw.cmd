@REM Maven wrapper script for Windows
@echo off
setlocal

set BASE_DIR=%~dp0
set MAVEN_WRAPPER_PROPERTIES=%BASE_DIR%.mvn\wrapper\maven-wrapper.properties

for /f "tokens=2 delims==" %%A in ('findstr "distributionUrl" "%MAVEN_WRAPPER_PROPERTIES%"') do set DISTRIBUTION_URL=%%A
for /f "tokens=*" %%A in ("%DISTRIBUTION_URL%") do set DISTRIBUTION_URL=%%A

for /f "tokens=2 delims=-" %%A in ("%DISTRIBUTION_URL%") do set MAVEN_VERSION_RAW=%%A
for /f "tokens=1 delims=-" %%A in ("%MAVEN_VERSION_RAW%") do set MAVEN_VERSION=%%A

set MAVEN_HOME=%USERPROFILE%\.m2\wrapper\dists\apache-maven-%MAVEN_VERSION%

if not exist "%MAVEN_HOME%" (
  mkdir "%MAVEN_HOME%"
  echo Downloading Maven %MAVEN_VERSION%...
  powershell -Command "Invoke-WebRequest -Uri '%DISTRIBUTION_URL%' -OutFile '%TEMP%\maven.zip'"
  powershell -Command "Expand-Archive -Path '%TEMP%\maven.zip' -DestinationPath '%MAVEN_HOME%'"
  del "%TEMP%\maven.zip"
)

for /r "%MAVEN_HOME%" %%F in (mvn.cmd) do set MVN_CMD=%%F

"%MVN_CMD%" %*
