package com.example.learnjava;

/**
 * Created by premkum3 on 12/26/2017.
 */
public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    public MathEquation(double leftVal, double rightVal, char opCode) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.opCode = opCode;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    private void setResult(double result) {
        this.result = result;
    }

    public void execute() {
        switch( this.getOpCode() ) {
            case 'a':
                this.setResult( this.getLeftVal() + this.getRightVal() );
                break;
            case 'd':
                this.setResult( this.getLeftVal() / this.getRightVal() );
                break;
            case 's':
                this.setResult( this.getLeftVal() - this.getRightVal() );
                break;
            case 'm':
                this.setResult( this.getLeftVal() * this.getRightVal() );
                break;
            default:
                System.out.println("This operation is not supported");
                break;
        }
    }
}
