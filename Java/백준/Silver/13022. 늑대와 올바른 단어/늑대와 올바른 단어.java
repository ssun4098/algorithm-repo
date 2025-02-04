import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        if (isValidWolfString(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isValidWolfString(String s) {
        int index = 0;
        int n = s.length();

        while (index < n) {
            int[] count = new int[4]; // w, o, l, f 개수 저장
            char[] order = {'w', 'o', 'l', 'f'};
            int i = 0;

            // w, o, l, f 순서대로 개수 세기
            while (i < 4) {
                while (index < n && s.charAt(index) == order[i]) {
                    count[i]++;
                    index++;
                }
                i++;
            }

            // "wolf" 순서를 다 못 채운 경우
            if (i < 4) return false;

            // w, o, l, f 개수가 같지 않으면 잘못된 단어
            if (!(count[0] == count[1] && count[1] == count[2] && count[2] == count[3])) {
                return false;
            }

            // 다음 wolf 그룹이 올 때, 현재 그룹보다 작으면 안됨
            if (index < n && s.charAt(index) == 'w' && count[0] < 1) {
                return false;
            }
        }

        return true;
    }
}