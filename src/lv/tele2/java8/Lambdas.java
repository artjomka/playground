package lv.tele2.java8;

import java.io.BufferedReader;
import java.io.IOException;

public class Lambdas {


    public static void main(String[] args) {

        ExampleClass exampleClass = new ExampleClass();
        try {
            BufferedReaderProcessor bufferedReaderProcessor = (BufferedReader br) ->
                    br.readLine() + " " + br.readLine();
            String line = exampleClass.readFromFile(bufferedReaderProcessor);
            System.out.println("line = " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
