import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int least = Integer.MAX_VALUE;
    static int arr[][];
    static int visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];

        //Initialize array
        for(int i=0; i<N; i++){
            String str = bf.readLine();
            for(int j=0; j<M;j++){
                arr[i][j] = str.charAt(j)-'0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0,0);
        System.out.println(least == Integer.MAX_VALUE ? -1 : least);
    }

    public static void bfs(int x, int y){
        Queue<point> q = new LinkedList<>();
        q.add(new point(x,y,1,0));
        visited[y][x] = 0;

        while (!q.isEmpty()){
            point current = q.poll();

            if(current.y == N-1 && current.x ==M-1){
                least = current.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (!(0 <= nx && nx <M && 0 <= ny && ny <N) || visited[ny][nx]<= current.blockCrashed) {
                    continue;
                }

                if(arr[ny][nx]==0){
                    visited[ny][nx] = current.blockCrashed;
                    q.add(new point(nx,ny, current.time+1,current.blockCrashed));
                }
               else{
                    if(current.blockCrashed==0){
                        visited[ny][nx] = current.blockCrashed+1;
                        q.add(new point(nx,ny,current.time+1, current.blockCrashed+1));
                    }
                }
            }
        }

    }
}

class point{
    int x,y,time;
    int blockCrashed;
    point(int x,int y,int time,int blockCrashed){
        this.x=x;
        this.y=y;
        this.time=time;
        this.blockCrashed=blockCrashed;
    }
}