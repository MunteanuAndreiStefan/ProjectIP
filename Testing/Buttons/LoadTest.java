package Buttons;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class LoadTest {



    @Test
    public void ReadableFile() {

        File myTestFile = new File("C:\\Users\\alexa\\Desktop\\test.txt");
        if (myTestFile.canRead()) {
            System.out.println(myTestFile.getAbsolutePath() + " Readable! ");
        } else {
            System.out.println(myTestFile.getAbsolutePath() + " Unreadable! ");
        }
    }

    @Test
    public void EmptyFile() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alexa\\Desktop\\test.txt"));

        if (br.readLine() == null) {
            System.out.println("Empty File!");
        }
        else System.out.println("The file is not empty!");

    }


}