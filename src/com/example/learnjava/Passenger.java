package com.example.learnjava;

/**
 * Created by premkum3 on 12/28/2017.
 */
public class Passenger {
    private int freeBags;
    private int checkedBags;
    private double perBagFee;

    public Passenger(){}

    public Passenger(int freeBags) {
        this( (freeBags > 1) ? 25d : 50d );
        this.freeBags = freeBags;
    }

    public Passenger(int freeBags, int checkedBags) {
        this.freeBags = freeBags;
        this.checkedBags = checkedBags;
    }

    private Passenger (double perBagFee) {
        this.perBagFee = perBagFee;
    }

    public int getCheckedBags() { return checkedBags; }

}
