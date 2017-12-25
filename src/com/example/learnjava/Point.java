package com.example.learnjava;

/**
 * Created by premkum3 on 12/1/2017.
 */
public class Point implements Comparable<Point> {
    private int A;
    private int B;
    private int C;

    public Point(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    @Override
    public int compareTo(Point o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        //this optimization is usually worthwhile, and can
        //always be added
        if (this == o) return EQUAL;

        //for A
        if (this.getA() < o.getA()) return BEFORE;
        if (this.getA() > o.getA()) return AFTER;

        //for B
        if (this.getB() < o.getB()) return BEFORE;
        if (this.getB() > o.getB()) return AFTER;

        //for C
        if (this.getC() < o.getC()) return BEFORE;
        if (this.getC() > o.getC()) return AFTER;

        //all comparisons have yielded equality
        //verify that compareTo is consistent with equals (optional)
        assert this.equals(o) : "compareTo inconsistent with equals.";

        return EQUAL;
    }

}
