import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] array = new char[n+1][n+1];
        String[] bodyArray = new String[5];
        boolean headFlag = false;
        int headX = 0;
        int headY = 0;


        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= n; j++) {
                array[i][j] = s.charAt(j-1);
                if(!headFlag && array[i][j] == '*') {
                    headFlag = true;
                    headX = j;
                    headY = i;
                }
            }
        }

        int count = 0;
        // 왼팔
        for(int i = headX - 1; i > 0; i--) {
            if(array[headY+1][i] == '*') {
                count++;
                continue;
            }
            break;
        }
        bodyArray[0] = String.valueOf(count);
        count = 0;
        // 오른팔
        for(int i = headX + 1; i <= n; i++) {
            if(array[headY+1][i] == '*') {
                count++;
                continue;
            }
            break;
        }
        bodyArray[1] = String.valueOf(count);
        count = 0;
        // 허리
        for(int i = headY + 2; i <= n; i++) {
            if(array[i][headX] == '*') {
                count++;
                continue;
            }
            break;
        }
        bodyArray[2] = String.valueOf(count);
        count = 0;
        // 왼쪽 다리
        for(int i = headY + 1 + Integer.parseInt(bodyArray[2]) + 1; i <= n; i++) {
            if(array[i][headX-1] == '*') {
                count++;
                continue;
            }
            break;
        }
        bodyArray[3] = String.valueOf(count);
        count = 0;
        // 오른쪽 다리
        for(int i = headY + 1 + Integer.parseInt(bodyArray[2]) + 1; i <= n; i++) {
            if(array[i][headX+1] == '*') {
                count++;
                continue;
            }
            break;
        }
        bodyArray[4] = String.valueOf(count);
        bw.write(  (headY + 1) + " " + headX + "\n");
        bw.write(String.join(" ", bodyArray));
        bw.close();
        br.close();
    }
}