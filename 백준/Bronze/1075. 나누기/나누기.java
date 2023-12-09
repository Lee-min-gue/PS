import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int F = sc.nextInt();
        
        N = (N / 100) * 100;  // 마지막 두 자리를 00으로 만듦

        for (int i = 0; i < 100; i++) {
            if (N % F == 0) {  // F로 나누어떨어지는 경우
                if (i < 10) System.out.println("0" + i);  // i가 한자리 수인 경우
                else System.out.println(i);
                break;
            }
            N++;  // 다음 수로 이동
        }
        
        sc.close();
    }
}
