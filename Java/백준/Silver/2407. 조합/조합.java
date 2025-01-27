import java.io.*;
import java.math.BigInteger;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        bw.write(combination(n, m).toString());
        br.close();
        bw.close();
    }

    // 조합 계산 메서드(BigInteger 사용)
    public static BigInteger combination(int n, int m) {
        if (m > n - m) { // 대칭성을 이용해 m을 최소화
            m = n - m;
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
            result = result.divide(BigInteger.valueOf(i + 1));
        }
        return result;
    }
}
