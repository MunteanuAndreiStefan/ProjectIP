/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dodu_
 */
public class DecisionTest {
    
    public DecisionTest() {
    }
    @Test
    public void testCheck() throws IOException, ParseException {
        System.out.println("check");
        JSONParser parser = new JSONParser();
        List<JSONObject> objects = new ArrayList<>();
        JSONObject obj =  new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONObject obj3 = new JSONObject();
         Object oc = parser.parse(new FileReader("D:\\IpTestN\\e1j.json"));
         obj=(JSONObject)oc;
         System.out.println(obj);
         Object oc2 = parser.parse(new FileReader("D:\\IpTestN\\ex2j.json"));
         obj2=(JSONObject)oc2;
         System.out.println(obj2);
         Object oc3 = parser.parse(new FileReader("D:\\IpTestN\\e3j.json"));
         obj3=(JSONObject)oc3;
         System.out.println(obj3);
         objects.add(obj);
         objects.add(obj2);
         objects.add(obj3);
         System.out.println(objects);
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("Maimuta","Elefant","Urs","Caine","Rozatoare");
        System.out.println(items);
        Decision instance = new Decision();
        Pair<String, Double> expResult = new Pair<>("Urs", 90.0);
        Pair<String, Double> result=instance.check(objects, items);
        assertEquals(result,expResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
