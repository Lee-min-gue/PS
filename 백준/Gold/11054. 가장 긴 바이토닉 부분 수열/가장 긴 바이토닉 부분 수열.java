import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 수열의 크기를 입력 받음
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();  // 수열의 요소를 입력 받음
        }

        System.out.println(findLongestBitonicSubsequence(array));
        scanner.close();
    }

    private static int findLongestBitonicSubsequence(int[] array) {
        int n = array.length;
        int[] dpInc = new int[n];  // 증가 부분 수열의 길이 저장
        int[] dpDec = new int[n];  // 감소 부분 수열의 길이 저장

        // 증가 부분 수열 길이 계산
        for (int i = 0; i < n; i++) {
            dpInc[i] = 1;  // 초기 값 1 설정
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && dpInc[j] + 1 > dpInc[i]) {
                    dpInc[i] = dpInc[j] + 1;
                }
            }
        }

        // 감소 부분 수열 길이 계산
        for (int i = n - 1; i >= 0; i--) {
            dpDec[i] = 1;  // 초기 값 1 설정
            for (int j = n - 1; j > i; j--) {
                if (array[j] < array[i] && dpDec[j] + 1 > dpDec[i]) {
                    dpDec[i] = dpDec[j] + 1;
                }
            }
        }

        // 바이토닉 수열의 최대 길이 계산
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dpInc[i] + dpDec[i] - 1);
        }

        return maxLen;
    }
}
