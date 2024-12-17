import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] array = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
        String s = br.readLine();
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int r = c - 'A';
            sum += array[r];
        }
        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }
}