package com.example.learnjava;

import java.util.Objects;

/**
 * Created by premkum3 on 12/1/2017.
 */
public class Triangle implements Comparable<Triangle> {
    private Point first;
    private Point second;
    private Point third;

    Triangle(Point first, Point second, Point third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getThird() {
        return third;
    }

    public void setThird(Point third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return Objects.equals(this.getFirst(), triangle.getFirst());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getFirst());
    }

    @Override
    public int compareTo(Triangle o)
    {
        final int EQUAL = 0;

        int comparison = this.getFirst().compareTo(o.getFirst());
        if( comparison != EQUAL )
            return comparison;

        comparison = this.getSecond().compareTo(o.getSecond());
        if( comparison != EQUAL )
            return comparison;

        comparison = this.getThird().compareTo(o.getThird());
        if( comparison != EQUAL )
            return comparison;

        assert this.equals(o);

        return EQUAL;
    }
}
