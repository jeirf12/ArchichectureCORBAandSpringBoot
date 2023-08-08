@echo off

Title Client

for /f "usebackq delims=, tokens=2" %%a in (list.csv) do (
    if exist "%%~a" (
        if exist Client.jar goto runServer
        else goto compileJar
    )
    goto downloadDependency
)

:downloadDependency
pwsh -command "Import-Csv .\list.csv | ForEach-Object { iwr -uri $_.uri -OutFile $_.name }" > NUL 2>&1 && md bin
javac -d bin -sourcepath src -cp ..\Common\Common.jar;.\javax.ws.rs-api-2.0.1.jar;.\jersey-media-json-jackson-2.23.1.jar src\client\services\*.java
javac -d bin -sourcepath src -cp ..\Common\Common.jar;.\javax.ws.rs-api-2.0.1.jar;.\jersey-media-json-jackson-2.23.1.jar src\client\view\*.java

:compileJar
jar cfvm Client.jar manifest.mf -C bin .

:runServer
cls
java -jar Client.jar
