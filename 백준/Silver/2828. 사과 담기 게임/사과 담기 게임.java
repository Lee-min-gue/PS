import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 스크린의 칸 수
        int M = scanner.nextInt(); // 바구니의 크기
        int J = scanner.nextInt(); // 사과의 개수

        int[] apples = new int[J]; // 사과가 떨어지는 위치를 저장하는 배열
        for (int i = 0; i < J; i++) {
            apples[i] = scanner.nextInt();
        }

        int basketStart = 1; // 바구니의 시작 위치
        int basketEnd = M; // 바구니의 끝 위치
        int move = 0; // 바구니가 이동한 거리

        for (int i = 0; i < J; i++) {
            if (apples[i] < basketStart) { // 사과가 바구니의 왼쪽에 떨어질 경우
                move += (basketStart - apples[i]); // 바구니를 왼쪽으로 이동
                basketEnd -= (basketStart - apples[i]);
                basketStart = apples[i];
            } else if (apples[i] > basketEnd) { // 사과가 바구니의 오른쪽에 떨어질 경우
                move += (apples[i] - basketEnd); // 바구니를 오른쪽으로 이동
                basketStart += (apples[i] - basketEnd);
                basketEnd = apples[i];
            }
        }

        System.out.println(move); // 바구니가 이동한 거리를 출력
    }
}
