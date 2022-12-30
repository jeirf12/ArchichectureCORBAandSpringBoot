@echo off

Title Server Notify
mkdir bin
start cmd /C "orbd -ORBInitialHost localhost -ORBInitialPort 3030"
javac -d bin -sourcepath src -cp ..\Common\Common.jar src\server\utilities\*
javac -d bin -sourcepath src -cp ..\Common\Common.jar src\server\repository\*
javac -d bin -sourcepath src -cp ..\Common\Common.jar src\server\controllers\*
javac -d bin -sourcepath src -cp ..\Common\Common.jar src\server\services\*

jar cfvm ServerNotify.jar manifest.mf -C bin .

cls
java -jar ServerNotify.jar
