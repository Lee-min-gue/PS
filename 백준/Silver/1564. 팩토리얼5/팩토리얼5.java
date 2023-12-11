import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long t = 1L;
        final long MOD = (long) Math.pow(10, 12);

        for (long i = 1; i <= n; ++i) {
            t *= i;
            while (t % 10 == 0) {
                t /= 10;
            }
            t %= MOD;
        }

        System.out.printf("%05d", t % 100000);
    }
}
