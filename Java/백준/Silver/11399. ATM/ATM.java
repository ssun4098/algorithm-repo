import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] array2 = new int[n];
        String s = br.readLine();
        String[] ss = s.split(" ");
        for(int i = 0; i < ss.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(array);
        int sum = array[0];
        array2[0] = sum;
        for(int i = 1; i < array.length; i++) {
            sum += array[i] + array2[i-1];
            array2[i] = array[i] + array2[i-1];
        }
        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }
}