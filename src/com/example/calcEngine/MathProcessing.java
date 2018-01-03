package com.example.calcEngine;

/**
 * Created by premkum3 on 1/2/2018.
 */
public interface MathProcessing {
    String SEPERATOR = " ";

    public String getKeyWord();
    public char getSymbol();
    public double doCalculation(double leftVal, double rightVal);
}
