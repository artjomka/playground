package lv.tele2.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExampleClass {


    public void runableExample() {
        Runnable r1 = () -> System.out.println("Run from lambda");

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Run from anonymous class ");
            }
        };

        process(r1);
        process(r2);
        process(() -> method());

    }

    private void method() {
        System.out.println("Run as lambda passed directly ");
    }

    public void process(Runnable runnable) {
        runnable.run();
    }

    public String readFromFile(BufferedReaderProcessor b) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\jvm\\Projects\\playground\\src\\lv\\tele2\\java8\\file.txt"))) {
            return b.process(br);
        }

    }

    public void methodReference() {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));

        List<String> str2 = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);
    }


}
