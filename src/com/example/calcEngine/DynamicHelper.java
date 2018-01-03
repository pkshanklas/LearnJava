package com.example.calcEngine;

/**
 * Created by premkum3 on 1/2/2018.
 */
public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers) {
        this.handlers = handlers;
    }

    public String process(String statement) {
        String[] parts = statement.split( MathProcessing.SEPERATOR );
        String keyWord = parts[0];

        MathProcessing theHandler = null;
        for(MathProcessing handler: handlers) {
            if(keyWord.equalsIgnoreCase(handler.getKeyWord())) {
                theHandler = handler;
            }
        }

        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        double result = theHandler.doCalculation(leftVal, rightVal);

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(" ");
        sb.append(theHandler.getKeyWord());
        sb.append(" ");
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }

}
