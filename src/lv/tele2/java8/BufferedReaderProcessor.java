package lv.tele2.java8;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    public String process(BufferedReader bufferedReader) throws IOException;
}
