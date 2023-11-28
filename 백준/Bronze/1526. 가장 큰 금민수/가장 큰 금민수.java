import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = -1;

        for (int i = 4; i <= N; i++) {
            String temp = Integer.toString(i);
            int cnt = 0;

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '4' || temp.charAt(j) == '7') {
                    cnt++;
                }
            }

            if (cnt == temp.length()) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}
