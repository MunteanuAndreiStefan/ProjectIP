package utils;

import java.io.*;

public class ObjectSerializable
{
    /*
    USAGE:
    MyTestPotato myTestPotato = new MyTestPotato(2);
    ObjectSerializable.save(myTestPotato, "da.cartof");
    MyTestPotato secondPotato = (MyTestPotato) ObjectSerializable.load("da.cartof");
     */
    public static void save(Object object, String location)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(location);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            //System.out.print("Serialized data is saved in " + location);
        } catch (IOException i)
        {
            i.printStackTrace();
        }
    }

    public static Object load(String location)
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(location);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object object = in.readObject();
            in.close();
            fileIn.close();
            return object;
        } catch (IOException i)
        {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c)
        {
            System.err.println("Class not found");
            c.printStackTrace();
            return null;
        }
    }
}
