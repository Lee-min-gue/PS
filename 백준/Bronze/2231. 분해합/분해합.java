import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Num = 1;
        int sum = 0;
        boolean found = false;

        while (Num <= N) {
            sum = 0;
            sum += Num;
            String Num2 = Integer.toString(Num);

            for (int i = 0; i < Num2.length(); i++) {
                sum += Num2.charAt(i) - '0';
            }

            if (sum == N) {
                found = true;
                break;
            }

            Num++;
        }

        if (found) {
            System.out.println(Num);
        } else {
            System.out.println(0);
        }
    }
}