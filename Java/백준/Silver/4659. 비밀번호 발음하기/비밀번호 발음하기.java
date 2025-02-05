import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            if(s.equalsIgnoreCase("end")) {
                break;
            }
            // first
            Pattern firstPattern = Pattern.compile("[a|e|i|o|u]");
            Matcher firstMatcher = firstPattern.matcher(s);
            if(!firstMatcher.find()) {
                printFail(s);
                continue;
            }

            Pattern secondPattern = Pattern.compile("[aeiou]{3}");
            Matcher secondMatcher = secondPattern.matcher(s);
            if(secondMatcher.find()) {
                printFail(s);
                continue;
            }

            Pattern secondPattern2 = Pattern.compile("[^aeiou]{3}");
            Matcher secondMatcher2= secondPattern2.matcher(s);
            if(secondMatcher2.find()) {
                printFail(s);
                continue;
            }
            Pattern thirdPattern = Pattern.compile("([^eo])\\1");
            Matcher thirdMatcher = thirdPattern.matcher(s);
            if(thirdMatcher.find()) {
                printFail(s);
                continue;
            }
            bw.write(String.format("<%s> is acceptable.%n", s));
        }

        bw.close();
        br.close();
    }

    private static void printFail(String s) throws IOException {
        bw.write(String.format("<%s> is not acceptable.%n", s));
    }
}

