import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static BufferedWriter bw;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        int pivot = -1;

        for(int i = n - 1; i > 0; i--) {
            if(array[i] > array[i - 1]) {
                pivot = i - 1;
                break;
            }
        }
        if(pivot == -1) {
            bw.write(String.valueOf(-1));

        } else {
            int min = Integer.MAX_VALUE;
            int j = -1;

            // 최솟값 찾기
            for(int i = n - 1; i > pivot; i--) {
                if(array[i] < min && array[pivot] < array[i]) {
                    min = array[i];
                    j = i;
                }
            }

            // swep
            int temp = array[pivot];
            array[pivot] = array[j];
            array[j] = temp;

            Arrays.sort(array, pivot + 1, n);
            bw.write(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }

        bw.close();
        br.close();
    }

}