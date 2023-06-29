import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        double sum = 0;
        int julsak = (int) Math.round(N * 0.15);
        for (int i = julsak; i < N - julsak; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round(sum / (N - 2 * julsak)));
    }
}