package com.example.learnjava;

/**
 * Created by premkum3 on 12/26/2017.
 */
public class CalcEngine {

    public static void main(String[] args) {
//        MathEquation[] equations = new MathEquation[4];
//        equations[0] = new MathEquation('d', 100.0d, 50.0d);
//        equations[1] = new MathEquation('a', 25.0d, 92.0d);
//        equations[2] = new MathEquation('s', 225.0d, 17.0d);
//        equations[3] = new MathEquation('m', 11.0d, 3.0d);
//
//        for(MathEquation equation: equations) {
//            equation.execute();
//            System.out.println("Result:  " +equation.getResult());
//        }
//
//        System.out.println("Using Inheritance");
//
//        CalculateBase[] calculations = {
//                new Adder(25.0d, 92.0d),
//                new Subtractor(225.0d, 17.0d),
//                new Divider(100.0d, 50.0d),
//                new Multiplier(11.0d, 3.0d),
//        };
//
//        for(CalculateBase cal: calculations) {
//            cal.calculate();
//            System.out.println( "Result: " + cal.getResult() );
//        }

        String[] strings = {
                "add 1.0",
                "add 25.0 92.0",
                "divide 100.0 50.0",
                "multiply 11.0 3.0",
                "subtract 225.0 17.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for(String str: strings) {
            try {
                helper.process(str);
                System.out.println(helper);
            }
            catch( IllegalStatementException e ) {
                System.out.println("Illegal Statement Exception: " + e.getMessage());
                if( e.getCause() != null )
                    System.out.println("Original Exception: " + e.getCause().getMessage());
            }
        }
    }

}
