package Testing.Buttons;

import Buttons.Load;
import org.junit.Test;
import sample.Decision;

import java.io.*;

import static org.junit.Assert.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LoadTest {


    @Test
    public void objectCreated() {
        Load button = new Load();
        assertNotNull(button);
    }

    @Test
    public void ReadableFile() {

        String filePath = new File("test.txt").getAbsolutePath();
        File file = new File(filePath);
        System.out.println(filePath);
        assertNotNull(file.canRead());
    }

    @Test
    public void EmptyFile() throws IOException {

        String filePath = new File("test.txt").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        assertNotNull(br.readLine());



    }


}