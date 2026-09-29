@echo off
if not exist out mkdir out
javac -d out src\*.java
if errorlevel 1 (
    echo.
    echo Compilation failed. Check the Java errors above.
    pause
    exit /b 1
)
echo.
echo Compilation successful.
echo Starting application...
echo.
java -cp out Main
pause
