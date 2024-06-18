import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] A;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int[] dp = new int[n];
        int[] prevIndex = new int[n];
        Arrays.fill(prevIndex, -1);

        ArrayList<Integer> lis = new ArrayList<>();
        ArrayList<Integer> lisIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pos = Collections.binarySearch(lis, A[i]);

            if (pos < 0) pos = -(pos + 1);

            if (pos < lis.size()) {
                lis.set(pos, A[i]);
                lisIndices.set(pos, i);
            } else {
                lis.add(A[i]);
                lisIndices.add(i);
            }

            dp[i] = pos + 1;
            if (pos > 0) prevIndex[i] = lisIndices.get(pos - 1);
        }

        int len = lis.size();
        System.out.println(len);

        int[] result = new int[len];
        int index = lisIndices.get(len -1);
        for (int i = len - 1; i >= 0; i--) {
            result[i] = A[index];
            index = prevIndex[index];
        }

        for (int i = 0; i < len; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
