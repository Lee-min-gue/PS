import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong();
        scanner.close();

        long sum = 0;
        int n = 0;

        while (sum <= s) {
            n++;
            sum += n;
        }

        System.out.println(n - 1);
    }
}
