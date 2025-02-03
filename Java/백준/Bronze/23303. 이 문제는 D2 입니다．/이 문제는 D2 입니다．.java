import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern pattern = Pattern.compile("d2", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()) {
            System.out.print("D2");
        } else {
            System.out.print("unrated");
        }
        sc.close();
    }
}