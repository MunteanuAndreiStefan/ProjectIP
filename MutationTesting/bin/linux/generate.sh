JTOOLSPATH=$JAVA_HOME/lib/tools.jar
export JTOOLSPATH
OPENJAVAPATH=$PWD/../../../Dependencies/openjava.jar
export OPENJAVAPATH
MUJAVAPATH=$PWD/../../../Dependencies/mujava.jar
export MUJAVAPATH
CLASSPATH=$CLASSPATH:.:$MUJAVAPATH:$OPENJAVAPATH:$JTOOLSPATH
export CLASSPATH
cd ../..
java mujava.gui.GenMutantsMain
