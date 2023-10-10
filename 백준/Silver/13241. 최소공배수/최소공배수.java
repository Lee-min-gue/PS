import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        System.out.println(lcm(a, b));
    }
    
    // 유클리드 호제법을 사용하여 최대공약수(GCD) 계산
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    // 두 수의 곱을 최대공약수(GCD)로 나누어 최소공배수(LCM) 계산
    public static long lcm(long a, long b) {
        return (a * b / gcd(a, b));
    }
}
