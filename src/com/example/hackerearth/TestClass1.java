package com.example.hackerearth;

import java.util.Scanner;

/**
 * Created by premkum3 on 1/7/2018.
 */
public class TestClass1 {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);

        //first incense points
        double x1 = s.nextDouble(), y1 = s.nextDouble();
        double x2 = s.nextDouble(), y2 = s.nextDouble();

        //calculate distance square;
//        double distance = ((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

        //no of house Points
        int nP = s.nextInt();

        //x pos of points
        double[] xPos = new double[nP];
        //y pos of points
        double[] yPos = new double[nP];

        //reading xPos and yPos
        for(int i=0; i<nP ; i++)
            xPos[i] = s.nextDouble();
        for(int i=0; i<nP ; i++)
            yPos[i] = s.nextDouble();

        //No of queries
        int t = s.nextInt();

        while( t-- > 0 ) {
            int count = 0;
            int time = s.nextInt();
//            System.out.println(time);

            //check if circles intersect
//            boolean bIntersect = ((time+time)*(time+time) < distance ? true : false);

            int radius = time*time;

            for(int i=0; i<nP; i++) {
                boolean pointInFirstCircle = ( (xPos[i]-x1)*(xPos[i]-x1) + (yPos[i]-y1)*(yPos[i]-y1) ) <= radius;
                boolean pointInSecondCircle = ( (xPos[i]-x2)*(xPos[i]-x2) + (yPos[i]-y2)*(yPos[i]-y2) ) <= radius;

                if(pointInFirstCircle && pointInSecondCircle) {
                    count++;
                }


            }

            System.out.println(count);
        }

        s.close();
    }
}
