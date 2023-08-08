@echo off

if exist bin (
  if exist Common.jar goto fin
  else rm bin
)

mkdir bin
javac -d bin -sourcepath src src\common\utilities\*.java
javac -d bin -sourcepath src src\common\entities\*.java
javac -d bin -sourcepath src src\common\soap_server_notify\IControllerNotifyPackage\*.java
javac -d bin -sourcepath src -cp bin\ src\common\soap_server_notify\*.java

jar cvf Common.jar -C bin . && copy Common.jar ..\\ServerStatement\\src\\main\\resources

:fin
