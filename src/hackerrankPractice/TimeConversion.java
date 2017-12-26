package hackerrankPractice;

import java.sql.Time;
import java.util.Scanner;

/**
 * Created by premkum3 on 12/26/2017.
 */
public class TimeConversion {

    public static String timeConversion(String s) {
        char[] str = s.toCharArray();
        String[] strs = s.split(":");
        StringBuffer result = new StringBuffer();

        int hours = Integer.parseInt(strs[0]);
        int minutes = Integer.parseInt(strs[1]);
        int seconds = Integer.parseInt(strs[2]);

        if( hours == 12 &&  strs[3].equals("AM") ) {
            result.append("00");
            result.append(":");
            result.append("00");
            result.append(":");
            result.append(seconds);
            result.append(":");
        }
        else if( hours == 12 &&  strs[3].equals("PM") ) {
            result.append("12");
            result.append(":");
            result.append(minutes);
            result.append(":");
            result.append(seconds);
            result.append(":");
        }
        else if( strs[3].equals("PM") ) {
            result.append(hours+12);
            result.append(":");
            result.append(minutes);
            result.append(":");
            result.append(seconds);
            result.append(":");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(timeConversion(s));

    }
}
