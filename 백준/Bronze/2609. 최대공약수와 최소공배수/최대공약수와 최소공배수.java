import java.util.*;
class Main {
    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }

    public static int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        return (a * b) / gcd;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int gcd = getGCD(num1, num2);
        int lcm = getLCM(num1, num2);

        System.out.println(gcd);
        System.out.println(lcm);
    }
}