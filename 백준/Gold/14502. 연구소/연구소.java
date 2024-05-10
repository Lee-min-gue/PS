import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int safeBlock;

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     N = sc.nextInt();
     M = sc.nextInt();
     arr = new int[N][M];
        //입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //벽세우기
        Wall(0);

        //정답 출력
        System.out.println(safeBlock);
    }

    //dfs로 벽 세우기
    static void Wall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    Wall(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue q = new ArrayDeque();

        //바이러스 위치 큐에 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    q.add(new Node(j, i));
                }
            }
        }

        int[][] arr2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr2[i][j] = arr[i][j];
            }
        }
        
        //bfs 시작
        while (!q.isEmpty()) {
            Node current = (Node) q.poll();
            for (int i = 0; i < 4; i++) {
              int cx = current.x + dx[i];
              int cy = current.y + dy[i];
              if (cx<0 || cy<0 || cx>=M || cy>=N) {
                  continue;
              }
              if (arr2[cy][cx] == 0) {
                  arr2[cy][cx] = 2;
                  q.add(new Node(cx, cy));
              }
            }
        }

        //안전지역 세기
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr2[i][j] == 0) {
                    cnt++;
                }
            }
        }

        safeBlock = Math.max(cnt, safeBlock);
    }
}
class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
