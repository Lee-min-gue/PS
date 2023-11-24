import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String distance = scanner.next();
        int realDistance = 0;
        int power = 1;

        for (int i = distance.length() - 1; i >= 0; i--) {
            int digit = distance.charAt(i) - '0';
            if (digit > 4) digit--;
            realDistance += digit * power;
            power *= 9;
        }

        System.out.println(realDistance);
    }
}
