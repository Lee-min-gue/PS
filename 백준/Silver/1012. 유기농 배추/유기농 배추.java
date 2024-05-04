import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while (T-- != 0){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int k = K;

            int count = 0;

            int[][] arr = new int[N][M];
            int[][] visited = new int[N][M];

            while (k-- != 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            }

            for (int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 0 || visited[i][j] == 1)continue;
                    Queue<point> q = new ArrayDeque<>();
                    count++;
                    q.add(new point(j,i));

                    while (!q.isEmpty()) {
                        point current = q.poll();
                        for (int e=0; e<4; e++) {
                            int nx = current.x + dx[e];
                            int ny = current.y + dy[e];
                            if(nx <0 || ny<0 || nx>=M || ny>=N)continue;

                            if(arr[ny][nx] == 1 && visited[ny][nx] == 0) {
                                q.add(new point(nx, ny));
                                visited[ny][nx] = 1;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

}
class point{
    int x;
    int y;
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}