package com.example.learnjava;

import com.example.calcEngine.CalculateBase;

/**
 * Created by premkum3 on 12/28/2017.
 */
public class Multiplier extends CalculateBase {
    public Multiplier() {}
    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        setResult( getLeftVal() * getRightVal() );
    }
}
