import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[] visited;
    static int count;
    public static void main(String[] args) {
        count=0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[y][x] = 1;
            arr[x][y] = 1;
        }
        for(int i=1;i<=N;i++){
            if(visited[i]==0){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void dfs(int start) {
        visited[start] = 1;
        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
}