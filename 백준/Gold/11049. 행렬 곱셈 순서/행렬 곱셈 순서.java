import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N - i + 1; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = j; k < j + i - 1; k++) {
                    int cost = dp[j][k] + dp[k + 1][j + i - 1] + matrix[j][0] * matrix[k][1] * matrix[j + i - 1][1];
                    min = Math.min(min, cost);
                }

                dp[j][j + i - 1] = min;
            }
        }

        System.out.println(dp[1][N]);
    }
}
