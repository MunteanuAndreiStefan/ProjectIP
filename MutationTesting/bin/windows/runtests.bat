set JTOOLSPATH=%JAVA_HOME%\lib\tools.jar
set OPENJAVAPATH=..\..\..\Dependencies\openjava.jar
set MUJAVAPATH=..\..\..\Dependencies\mujava.jar
REM put here your junit and hamcrest jar paths
REM get junit-<version>.<number> and hamcrest-core-<version>.<number> here:
REM https://github.com/junit-team/junit4/wiki/Download-and-Install
set JUNITPATH=
set HAMCRESTPATH=
set CLASSPATH=%CLASSPATH%;.;%JTOOLSPATH%;%OPENJAVAPATH%;%MUJAVAPATH%;%JUNITPATH%;%HAMCRESTPATH%
java mujava.gui.RunTestMain
Pause
