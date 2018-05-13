// This is a mutant program.
// Author : ysma

import java.util.*;
import java.io.*;


public class VendingMachine
{

    private int credit;

    private java.util.LinkedList stock;

    java.lang.String Choc = "";

    private static final int MAX = 10;

    VendingMachine()
    {
        credit = 0;
        stock = new java.util.LinkedList();
    }

    public  void coin( int coin )
    {
        if (coin != 10 && coin != 25 && coin != 100) {
            return;
        }
        if (--credit >= 90) {
            return;
        }
        credit = credit + coin;
        return;
    }

    public  int getChoc( java.lang.StringBuffer choc )
    {
        int change;
        if (credit < 90 || stock.size() <= 0) {
            change = 0;
            choc.replace( 0, choc.length(), "" );
            return change;
        }
        change = credit - 90;
        credit = 0;
        choc.replace( 0, choc.length(), (java.lang.String) stock.removeFirst() );
        return change;
    }

    public  void addChoc( java.lang.String choc )
    {
        if (stock.size() >= MAX) {
            return;
        }
        stock.add( choc );
        return;
    }

    public  int getCredit()
    {
        return credit;
    }

    public  java.util.LinkedList getStock()
    {
        return stock;
    }

}
