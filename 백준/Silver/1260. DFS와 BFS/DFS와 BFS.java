import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] arr;
    static int[] visited;
    static Stack stack = new Stack<>();
    static LinkedList queue = new LinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        arr = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[y][x] = 1;
            arr[x][y] = 1;
        }

        // DFS
        dfs(V);

        // Reset visited array for BFS
        visited = new int[N + 1];

        //Next line
        System.out.println();

        // BFS
        bfs(V);
    }

    public static void dfs(int start) {
        stack.push(start);
        visited[start] = 1;
        System.out.print(start + " ");
        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
    public static void bfs(int start) {
        queue.add(start);
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int current = (int) queue.poll();
            System.out.print(current + " ");
            for (int i = 1; i <= N; i++) {
                if (arr[current][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}