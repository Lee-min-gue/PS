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
            TreeMap<Integer, Integer> counter = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                switch (order) {
                    case 'I':
                        counter.put(num, counter.getOrDefault(num, 0) + 1);
                        break;
                    case 'D':
                        if (!counter.isEmpty()) {
                            if (num == -1) {
                                int first_key = counter.firstKey();
                                int count = counter.get(first_key);

                                if (count == 1) {
                                    counter.remove(first_key);
                                } else {
                                    counter.put(first_key, count - 1);
                                }
                            } else if (num == 1) {
                                int last_key = counter.lastKey();
                                int count = counter.get(last_key);

                                if (count == 1) {
                                    counter.remove(last_key);
                                } else {
                                    counter.put(last_key, count - 1);
                                }
                            }
                        }
                        break;
                }
            }

            if (counter.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                int first_key = counter.firstKey();
                int last_key = counter.lastKey();
                System.out.println(last_key + " " + first_key);
            }
        }
    }
}