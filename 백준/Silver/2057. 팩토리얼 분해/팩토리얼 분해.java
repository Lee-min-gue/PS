import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = sc.nextBigInteger();

        if (N.equals(BigInteger.ZERO)) {
            System.out.println("NO");
            return;
        }
       
        BigInteger[] factorial = new BigInteger[21];
        factorial[0] = BigInteger.ONE;

        for (int i = 1; i <= 20; i++) {
            factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));
        }

        for (int i = 20; i >= 0; i--) {
            if (N.compareTo(factorial[i]) >= 0) {
                N = N.subtract(factorial[i]);
            }
        }

        if (N.equals(BigInteger.ZERO)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
