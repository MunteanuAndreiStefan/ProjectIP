package Testing;

import org.junit.Assert;

import java.io.*;

import static org.junit.Assert.*;

public class ObjectSerializableTest {
    ObjectSerializable Object;

    String location = "C:\\Users\\alexa\\Desktop\\SerializeTest.txt";
    String concept = "Concept1";


    @org.junit.Test
    public void wellSerialized() throws IOException {

        //First version
//        try {
//            //what function returns
//            Object.save(location);
//            FileInputStream fis1 = new FileInputStream(location);
//            ObjectInputStream out1 = new ObjectInputStream(fis1);
//
//            //what we expect
//            FileOutputStream fileOut = new FileOutputStream(location);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            Object object = this;
//            out.writeObject(object);
//            out.close();
//            fileOut.close();
//            FileInputStream fis2 = new FileInputStream(location);
//            ObjectInputStream out2  = new ObjectInputStream(fis2);
//
//            assertEquals(out2,out1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Object.save(location);
        BufferedReader inputReader1 = new BufferedReader(new FileReader(location));
        System.out.println(inputReader1);

        FileOutputStream fileOut = new FileOutputStream(location);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        Object object = this;
        out.writeObject(object);
        out.close();
        fileOut.close();
        BufferedReader inputReader2 = new BufferedReader(new FileReader(location));

        assertEquals(inputReader2, inputReader1);


    }


    @org.junit.Test
    public void wellDeserialized() throws IOException, ClassNotFoundException {
        Object.load(location);

        FileInputStream fileIn = new FileInputStream(location);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object object = in.readObject();
        in.close();
        fileIn.close();

        Assert.assertEquals(Object, object);

    }
}