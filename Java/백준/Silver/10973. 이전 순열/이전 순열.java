import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        Integer [] array = new Integer[n];
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }

        int pivot = 10001;
        for(int i = n - 2; i >= 0; i--) {
            if(array[i] > array[i+1]) {
                pivot = i;
                break;
            }
        }
        if(pivot == 10001) {
            bw.write("-1");
        } else {
            int min = Integer.MIN_VALUE;
            for(int i = n - 1; i > pivot; i--) {
                if(array[i] > min && array[i] < array[pivot]) {
                    min = i;
                }
            }
            int temp = array[pivot];
            array[pivot] = array[min];
            array[min] = temp;

            Arrays.sort(array, pivot + 1, n, Collections.reverseOrder());
            bw.write(Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(" ")));
        }
        bw.close();
        br.close();
    }
}