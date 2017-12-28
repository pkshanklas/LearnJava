package com.example.learnjava;

/**
 * Created by premkum3 on 12/28/2017.
 */
public class Adder extends CalculateBase {
    public Adder() {}
    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        setResult( getLeftVal() + getRightVal() );
    }
}
