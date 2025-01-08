@echo off
REM Batch file to execute Maven test for SauceRunner class
echo Starting Maven Test Execution for SauceRunner...
mvn -Dtest=SauceRunner test
echo Test Execution Completed.
pause
