import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for(int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            int sum = 0, p = 1;
            for(int i = 0; i <sb.length(); i++) {
                if(sb.charAt(i) == 'X') {
                    p = 1;
                } else {
                    sum += p++;
                }
            }
            System.out.println(sum);
        }
    }
}
