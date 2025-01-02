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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++ ) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 0; i < n; i++ ) {
            bw.write(queue.poll() + "\n");
        }
        br.close();
        bw.close();
    }

}