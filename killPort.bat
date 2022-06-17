@ECHO OFF
SET killport=8080
for /f "tokens=5" %%p in ('netstat -aon ^| find /i "listening" ^| find "%killport%"') do taskkill /F /PID %%p
pause
START /b java -jar target/data.jar >> data.log &
