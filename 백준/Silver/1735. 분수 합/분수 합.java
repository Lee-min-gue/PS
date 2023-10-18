import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        // 두 분수의 합을 구한다.
        int numerator = A * D + B * C;
        int denominator = B * D;

        // 최대공약수(GCD)를 구한다.
        int gcdValue = gcd(numerator, denominator);

        // 결과를 기약분수 형태로 출력한다.
        System.out.println((numerator / gcdValue) + " " + (denominator / gcdValue));
    }

    private static int gcd(int a, int b) {
      while (b != 0) {
          int temp = a;
          a = b;
          b= temp % b;
      }
      return a;
    }
}
