package sample;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import weka.classifiers.Classifier;
import weka.core.Instances;

public class WekaDecision {
    public static BufferedReader readDataFile(String filename) {
        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
        }

        return inputReader;
    }

    public static void classify(String artffFormat) throws Exception {
        BufferedReader datafile = readDataFile(artffFormat);
        Instances data = new Instances(datafile);
        data.setClassIndex(data.numAttributes() - 1);
        Classifier cls = new weka.classifiers.trees.DecisionStump();
        //new weka.classifiers.trees.J48();
        cls.buildClassifier(data);
        System.out.println(cls);
    }
}