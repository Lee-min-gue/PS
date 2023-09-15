import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] check;
    static int[] arr;

    public static void find(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i;
                find( depth + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        arr = new int[M];

        find(0);
    }
}