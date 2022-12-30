@echo off

Title Client
pwsh -command "Import-Csv .\list.csv | ForEach-Object { iwr -uri $_.uri -OutFile $_.name }" && md bin
javac -d bin -sourcepath src -cp ..\Common\Common.jar;.\javax.ws.rs-api-2.0.1.jar;.\jersey-media-json-jackson-2.23.1.jar src\client\services\*.java
javac -d bin -sourcepath src -cp ..\Common\Common.jar;.\javax.ws.rs-api-2.0.1.jar;.\jersey-media-json-jackson-2.23.1.jar src\client\view\*.java

jar cfvm Client.jar manifest.mf -C bin .

cls
java -jar Client.jar
