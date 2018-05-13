Instructions:
    1) Get the junit and hamcrest libraries if you don't already have them (https://github.com/junit-team/junit4/wiki/Download-and-Install)
    2) Check if your JAVA_HOME environment variable is set (Linux: echo $JAVA_HOME, Windows: echo %JAVA_HOME%). If you don't have it set, please do so (JAVA_HOME is the location of your local install of the JDK)
    3) Modify the config file (enter the absolute path to the MutationTesting/exp folder)
    4) Open the runtests.bat file and fill in the paths to the hamcrest and junit .jar files
    
    If you want to generate files, put you .java classes in the "src" folder and the compiled .class files in the "classes" folder (both are present in the "exp" folder). After that, open the terminal/command prompt, navigate to the windows/linux folder and run generate.bat/generate.sh. Please be aware that an error will occur if you want to generate mutants for a class for which mutants already exist (delete the corresponding folder inside "results" if you want to generate again).
    
    If you want to test your mutants, put the compiled (.class) java unit test files in the "testset" folder, open the terminal/command prompt, navigate to the windows/linux folder and run runtests.bat/runtests.sh. Results will be written in the run_output.txt file.

    The files that come in the subfolders of the exp folder are just for testing, they can be safely removed.
    
    Do not modify the folder structure of the exp folder. The "classes", "results", "src" and "testset" folders must be present inside the exp directory, otherwise muJava will not work.
