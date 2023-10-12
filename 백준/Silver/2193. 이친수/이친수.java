import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] dp = new long[N+1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=2; i<=N; i++) {
            // 현재 자리수가 0인 경우, 이전 자리수가 0이거나 1인 경우 모두 가능
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            // 현재 자리수가 1인 경우, 이전 자리수가 반드시 0이어야 함 (연속된 11 방지)
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
