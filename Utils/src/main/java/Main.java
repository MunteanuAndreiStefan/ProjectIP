import utils.ObjectSerializable;

public class Main
{
    public static void main(String[] args)
    {
        MyTestPotato myTestPotato = new MyTestPotato(2);
        ObjectSerializable.save(myTestPotato, "da.cartof");

        MyTestPotato secondPotato = (MyTestPotato) ObjectSerializable.load("da.cartof");
        assert secondPotato != null;
        System.out.println("Potato: " + secondPotato.getCartof());
    }
}
