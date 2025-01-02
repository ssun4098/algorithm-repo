import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i = 0; i < n; i++ ) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        for(int i = 0; i < n; i++ ) {
            System.out.println(array[i]);
        }
        br.close();
    }

}