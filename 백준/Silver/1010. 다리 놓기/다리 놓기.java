import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            BigInteger result = factorial(M).divide(factorial(N).multiply(factorial(M-N)));
            System.out.println(result);
        }
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for(int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
