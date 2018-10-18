call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo call to runcrud has errors - breaking work
goto fail

:openbrowser
start "Firefox<3" "C:\Program Files\Mozilla Firefox\firefox.exe" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo opening firefox has errors - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Show is finished.