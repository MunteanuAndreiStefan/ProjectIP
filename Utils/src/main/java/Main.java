import utils.JsonTag;
import utils.ObjectSerializable;

public class Main
{
    public static void main(String[] args)
    {
//        MyTestPotato myTestPotato = new MyTestPotato(2);
//        ObjectSerializable.save(myTestPotato, "da.cartof");
//
//        MyTestPotato secondPotato = (MyTestPotato) ObjectSerializable.load("da.cartof");
//        assert secondPotato != null;
//        System.out.println("Potato: " + secondPotato.getCartof());

        JsonTag myStringTag = new JsonTag("tag1_name", "tag1");
        JsonTag myIntTag = new JsonTag("tag_2_nume", 2);
        JsonTag sectag = new JsonTag(myIntTag, myStringTag);
        sectag.setName("cartoful_pufos");
        JsonTag vectorTag = new JsonTag(sectag,myIntTag, myStringTag);

        String result = vectorTag.exportToJSON();
        System.out.println(result);
    }
}
