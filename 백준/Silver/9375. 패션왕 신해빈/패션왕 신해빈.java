import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            TreeMap<String, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String wear=st.nextToken();
                String type=st.nextToken();
                map.put(type,map.getOrDefault(type,0)+1);
            }

            int sum=1;

            for (Integer value : map.values()) {
                sum *= value+1;
            }
            System.out.println(sum-1);
        }
    }
}