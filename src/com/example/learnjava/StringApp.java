package com.example.learnjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by premkum3 on 12/28/2017.
 */
public class StringApp {

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
             reader =
                    new BufferedReader(
                        new FileReader(
                            "C:\\Users\\premkum3\\IdeaProjects\\LearnJava\\src\\com\\example\\learnjava\\Numbers.txt"
                        )
                    );

            String line = null;
            while( (line = reader.readLine()) != null ) {
                System.out.println(Integer.valueOf(line));
            }
        }
        catch( IOException e ) {
            System.out.println( "IO Exception: " + e.getMessage() );
        }
        catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        finally {
            try {
                if( reader!= null )
                    reader.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
