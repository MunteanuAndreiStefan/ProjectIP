import java.util.*;
import java.io.*;

public class VendingMachine
{
    private int credit;
    private LinkedList stock;
    String Choc = "";

    private static final int MAX = 10;

    VendingMachine()
    {
	credit = 0;
	stock  = new LinkedList();
    }

    public void coin (int coin)
    {
	if (coin != 10 && coin != 25 && coin != 100)
	    return;
	if (credit >= 90)
	    return;
	credit = credit + coin;
	return;
    }

    public int getChoc (StringBuffer choc)
    {
	int change;

	if (credit < 90 || stock.size() <= 0)
	    {
		change = 0;
		choc.replace (0, choc.length(), "");
		return (change);
	    }
	change = credit - 90;
	credit = 0;

	choc.replace (0, choc.length(), (String) stock.removeFirst());

	return (change);
    }

    public void addChoc (String choc)
    {
	if (stock.size() >= MAX)
	    return;
	stock.add (choc);
	return;
    }

    // Needed for testing
    public int getCredit ()
    {
	return (credit);
    }


    // Needed for testing
    public LinkedList getStock ()
    {
	return (stock);
    }

}
