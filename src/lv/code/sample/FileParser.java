package lv.code.sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * File parser will parse file
 */
public class FileParser {

    private static int doItCount = 0;

    public ArrayList<ParseResult> doIt(String x){
        try {
            Path path = Paths.get(x);
            ArrayList<ParseResult> parseResults = new ArrayList<>();
            // Read lines from file
            List<String> lines = Files.readAllLines(path);
            // Iterate all lines
            for (int i = 0; i < lines.size(); i++ ){
                String value1 = "";
                String value2 = "";
                String value3 = "";
                // Get line
                String line = lines.get(i);
                // Split line
                String[] split = line.split("|");
                // Loop
                for (int iz = 0; iz < split.length; iz++) {
                    if (split[iz].equals("value1")) {
                        if (doItCount < 100) {
                            value1 = split[iz];
                        }

                    } else if (split[iz].equals("value2")) {
                        System.out.print("Value 2 " + split[iz]);
                        value2 = split[iz];
                    } else if (split[iz].equals("hello")) {
                        value3 = split[iz] + " 3 ";
                        doItCount++;
                    }

                }
                parseResults.add(new ParseResult(value1, value2, value3, "",""));
            }
        } catch (IOException e) {
        }
        return null;
    }

    public static int getDoItCount() {
        return doItCount;
    }
}
