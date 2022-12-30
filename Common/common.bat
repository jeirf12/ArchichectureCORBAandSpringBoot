@echo off

mkdir bin
javac -d bin -sourcepath src src\common\utilities\*.java
javac -d bin -sourcepath src src\common\entities\*.java
javac -d bin -sourcepath src src\common\soap_server_notify\IControllerNotifyPackage\*.java
javac -d bin -sourcepath src -cp bin\ src\common\soap_server_notify\*.java

jar cvf Common.jar -C bin .
