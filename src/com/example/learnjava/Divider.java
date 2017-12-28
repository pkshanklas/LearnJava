package com.example.learnjava;

/**
 * Created by premkum3 on 12/28/2017.
 */
public class Divider extends CalculateBase {
    public Divider() {}
    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        setResult( getLeftVal() / getRightVal() );
    }
}
