@echo off

cd Common && common.bat && timeout /t 40 /nobreak > NUL && cd ..\ServerNotify && start cmd /K server.bat && cd ..\ServerStatement && timeout /t 20 /nobreak > NUL && start cmd /K server.bat && cd ..\Client && client.bat
