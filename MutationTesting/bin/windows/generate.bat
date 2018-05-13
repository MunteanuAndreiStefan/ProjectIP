set JTOOLSPATH=%JAVA_HOME%\lib\tools.jar
set OPENJAVAPATH=..\..\..\Dependencies\openjava.jar
set MUJAVAPATH=..\..\..\Dependencies\mujava.jar
set CLASSPATH=%CLASSPATH%;.;%JTOOLSPATH%;%OPENJAVAPATH%;%MUJAVAPATH%;
java mujava.gui.GenMutantsMain
Pause
