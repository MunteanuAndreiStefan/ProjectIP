/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dodu_
 */
public class WekaDecisionTest {
    
    public WekaDecisionTest() {
    }
      
    @Test
    public void testReadDataFile() throws FileNotFoundException, IOException {
        System.out.println("readDataFile");
        String filename = new File("text.txt").getAbsolutePath();
        BufferedReader expResult = new BufferedReader(new FileReader("D:\\IpTestN\\text.txt"));
        
        String tx1=expResult.readLine();
        BufferedReader result = WekaDecision.readDataFile(filename);
        String tx2=result.readLine();
        System.out.println(tx1);
        System.out.println(tx2);
        
        assertEquals(tx1, tx2);
    }

    @Test
    public void testClassify() throws Exception {
        System.out.println("classify");
        String artffFormat = "D:\\IpTestN\\formatarff.arff";
        WekaDecision.classify(artffFormat);
        
        
    }
    


}