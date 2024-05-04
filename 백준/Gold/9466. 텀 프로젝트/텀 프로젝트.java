import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine().trim());

            while (T-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                arr = new int[n + 1];
                visited = new boolean[n + 1];
                finished = new boolean[n + 1];
                count = 0;

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int i = 1; i <= n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                for (int i = 1; i <= n; i++) {
                    if (!visited[i]) {
                        dfs(i);
                    }
                }
                sb.append(n - count).append("\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int v) {
        if (visited[v]) return;
        visited[v] = true;
        int next = arr[v];
        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클을 찾은 경우
            for (int i = next; i != v; i = arr[i]) {
                count++;
            }
            count++;  // 시작 노드를 포함하여 카운트 증가
        }
        finished[v] = true;  // 작업 완료 표시
    }
}
