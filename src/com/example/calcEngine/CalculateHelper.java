package com.example.calcEngine;

import com.example.learnjava.Multiplier;
import com.example.learnjava.Subtractor;

/**
 * Created by premkum3 on 12/28/2017.
 */
public class CalculateHelper {

    public static final char ADD_SYMBOL = '+';
    public static final char SUBTRACT_SYMBOL = '-';
    public static final char DIVIDE_SYMBOL = '/';
    public static final char MULTIPLY_SYMBOL = '*';

    private MathCommand command;
    private double leftVal;
    private double rightVal;
    private double result;

    public CalculateHelper() {}

    public void process(String statement) throws IllegalStatementException {
        String[] parts = statement.split(" ");

        if( parts.length !=3 )
            throw new IllegalStatementException("number of parameters are not 3", statement);

        String command  = parts[0];

        try {
            this.leftVal = Double.parseDouble(parts[1]);
            this.rightVal = Double.parseDouble(parts[2]);
        }
        catch ( NumberFormatException e ) {
            throw new IllegalStatementException("operands are not number", statement, e);
        }

        setCommandFromString( command );

        if( this.command == null )
            throw new IllegalStatementException("invalid operation", statement);

        CalculateBase equation = null;
        switch ( command ) {
            case "add":
                equation = new Adder(leftVal, rightVal);
                break;
            case "subtract":
                equation = new Subtractor(leftVal, rightVal);
                break;
            case "divide":
                equation = new Divider(leftVal, rightVal);
                break;
            case "multiply":
                equation = new Multiplier(leftVal, rightVal);
                break;
            default:
                break;
        }

        equation.calculate();
        result = equation.getResult();
    }

    private void setCommandFromString( String command ) {
        switch( command ) {
            case "add":
                this.command = MathCommand.Add;
                break;
            case "subtract":
                this.command = MathCommand.Subtract;
                break;
            case "divide":
                this.command = MathCommand.Divide;
                break;
            case "multiply":
                this.command = MathCommand.Multiply;
                break;
            default:
                this.command = null;
                break;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(20);

        char symbol = ' ';
        switch(this.command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            default:
                break;
        }

        sb.append(leftVal);
        sb.append(" ");
        sb.append(symbol);
        sb.append(" ");
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }
}
