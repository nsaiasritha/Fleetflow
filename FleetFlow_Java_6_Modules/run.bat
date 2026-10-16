@echo off
cd /d "%~dp0"
if not exist out mkdir out
javac -d out src\fleetflow\*.java
if errorlevel 1 pause & exit /b 1
java -cp out fleetflow.Main
pause
