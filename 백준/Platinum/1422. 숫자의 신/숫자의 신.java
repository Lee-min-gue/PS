import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = br.readLine().trim();
            int sn = Integer.parseInt(arr[i]);
            max = Math.max(max, sn);
        }

        int remain = N - K;

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });

        StringBuilder result = new StringBuilder();
        boolean maxAppended = false;
        
        for (String s : arr) {
            if (!maxAppended && Integer.parseInt(s) == max) {
                for (int j = 0; j <= remain; j++) {
                    result.append(s);
                }
                maxAppended = true;
            } else {
                result.append(s);
            }
        }

        System.out.println(result.toString());
    }
}
