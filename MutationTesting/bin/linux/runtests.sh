JTOOLSPATH=$JAVA_HOME/lib/tools.jar;
OPENJAVAPATH=$PWD/../../../Dependencies/openjava.jar;
MUJAVAPATH=$PWD/../../../Dependencies/mujava.jar;
# put here your junit and hamcrest jar paths
# get junit-<version>.<number> and hamcrest-core-<version>.<number> here:
# https://github.com/junit-team/junit4/wiki/Download-and-Install
JUNITPATH=
HAMCRESTPATH=
CLASSPATH=$CLASSPATH:$MUJAVAPATH:.:$JTOOLSPATH:$OPENJAVAPATH:$JUNITPATH:$HAMCRESTPATH;
export CLASSPATH;
cd ../..;
java mujava.gui.RunTestMain > run_output.txt;
