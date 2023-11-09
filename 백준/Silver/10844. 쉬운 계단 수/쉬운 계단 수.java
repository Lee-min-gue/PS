import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // dp 배열 초기화
        long[][] dp = new long[N + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1; // 길이가 1인 경우, 각 숫자는 1개씩 계단 수가 됨
        }

        // 다이나믹 프로그래밍으로 계단 수 개수 구하기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1]; // 앞자리가 1인 경우
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8]; // 앞자리가 8인 경우
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000; // 앞자리가 j-1 또는 j+1인 경우
                }
            }
        }

        // 결과 출력
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }
        answer %= 1000000000;

        System.out.println(answer);
    }
}
