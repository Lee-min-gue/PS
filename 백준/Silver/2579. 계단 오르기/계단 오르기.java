import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N+1];
        int[] score = new int[N+1];
        
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }

        // 초기 점수 설정
        score[1] = arr[1];
        if (N >= 2) {
            score[2] = arr[1] + arr[2];
        }

        // 동적 프로그래밍으로 최대 점수 구하기
        for(int i = 3; i <= N; i++){
            score[i] = Math.max(score[i-3] + arr[i-1], score[i-2]) + arr[i];
        }

        System.out.println(score[N]);
    }
}