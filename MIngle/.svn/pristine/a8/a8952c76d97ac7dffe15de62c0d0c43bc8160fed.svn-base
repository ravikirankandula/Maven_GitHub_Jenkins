REM call mvn -f pom.xml clean install -U
echo off
set ENVIRONMENT=%1
set BROWSER=%2
set SUITE=%3
echo %ENVIRONMENT%
echo %BROWSER%
if /I %ENVIRONMENT%==OP (
 copy OPUserPropertiesFile\OPconfig.properties config.properties 
 goto RunCommand
 )
if /I %ENVIRONMENT%==CLOUD (
	copy CloudUserPropertiesFile\CloudConfig.properties config.properties 
goto RunCommand	
 )
echo You Entered %ENVIRONMENT%, is incorrect value. Kindly enter either CLOUD or OP
goto exit

:RunCommand
call mvn -f pom.xml test -DEnv=%ENVIRONMENT% -DBrowser=%BROWSER% -DSuite=%SUITE% -U
goto exit
:exit
pause