import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(countZerosInFactorial(N));
    }

    static int countZerosInFactorial(int N){
        int count = 0;
        for(int i = 5; N / i >= 1; i *= 5){
            count += N / i;
        }
        return count;
    }
}