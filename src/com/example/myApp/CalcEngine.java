package com.example.myApp;

import com.example.calcEngine.Adder;
import com.example.calcEngine.CalculateBase;
import com.example.calcEngine.Divider;
import com.example.calcEngine.DynamicHelper;
import com.example.calcEngine.MathProcessing;
import com.example.learnjava.Multiplier;
import com.example.learnjava.Subtractor;

/**
 * Created by premkum3 on 12/26/2017.
 */
public class CalcEngine {

    public static void main(String[] args) {
//        useCalcHelper();

        String[] statements = {
            "add 1.0 4.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder()
        });

        for(String s: statements) {
            String output = helper.process(s);
            System.out.println(output);
        }

    }

    public static void useCalcHelper() {
        System.out.println("Using Inheritance");

        CalculateBase[] calculations = {
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
                new Divider(100.0d, 50.0d),
                new Multiplier(11.0d, 3.0d),
        };

        for(CalculateBase cal: calculations) {
            cal.calculate();
            System.out.println( "Result: " + cal.getResult() );
        }

    }

}
