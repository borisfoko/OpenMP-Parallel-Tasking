:: Build All Java Example
@ECHO OFF

ECHO The following script will build the provided *.java objects to *.classes archiches

:: Variables definition
SET FILE_LIST=
FOR /r %%i in (*.java) DO CALL :ConcatRoutine %%~ni

::Show List of Java files
ECHO Java Filelist to be build
ECHO %FILE_LIST%
GOTO :BuildRoutine

:: String contat Routine
:ConcatRoutine
SET FILE_LIST=%FILE_LIST% %1.java
GOTO :EOF

:: Build Routine
:BuildRoutine
java -jar libraries\omp4j-1.2.jar -d classes -v %FILE_LIST%
GOTO :EndRoutine

:: End of program
:EndRoutine
ECHO Press any key to end the program
PAUSE >NUL