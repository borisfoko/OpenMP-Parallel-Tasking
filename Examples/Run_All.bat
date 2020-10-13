:: Build All Java Example
@ECHO OFF

ECHO The following script will execute the provided *.class objects
CD classes

FOR /L %%G IN (1,1,8) DO CALL :ExecuteExample %%G 
GOTO :EndRoutine

:ExecuteExample
ECHO Example(%1) will be started
java Example%1
ECHO Example (%1) execution finish
GOTO :WaitRoutine

:WaitRoutine
ECHO Press any key to continue the program
PAUSE >NUL
GOTO :EOF

:: End of program
:EndRoutine
CD ..
ECHO Press any key to end the program
PAUSE >NUL