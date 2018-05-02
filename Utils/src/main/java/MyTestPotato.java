import java.io.Serializable;

public class MyTestPotato extends ObjectSerializable implements Serializable
{
    private int cartof;

    public int getCartof()
    {
        return cartof;
    }

    public MyTestPotato(int cartof)
    {
        this.cartof = cartof;
    }

    public void setCartof(int cartof)
    {
        this.cartof = cartof;
    }
}
