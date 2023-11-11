import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] cats = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cats[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cats);
        
        int left = 0;
        int right = N - 1;
        int count = 0;

        while (left < right) {
            if (cats[left] + cats[right] <= K) {
                count++;
                left++;
                right--;
            } else {
                right--;
            }
        }
        
        System.out.println(count);
    }
}
