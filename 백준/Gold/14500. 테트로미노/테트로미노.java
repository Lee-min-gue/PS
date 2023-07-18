    import java.util.*;
    import java.io.*;
    public class Main {
        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};
        static boolean[][] visited;
        static int arr[][];
        static int max = 0;
        static int N;
        static int M;
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];

            //입력받기
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<M;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                   visited[i][j]=true;
                   solve(j,i,arr[i][j],1);
                   visited[i][j]=false;
                }
            }
            System.out.println(max);
        }
        public static void solve(int x,int y,int sum,int count){
            if(count == 4) {
                max = Math.max(max, sum);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if(!visited[ny][nx]) {

                    if(count == 2) {
                        visited[ny][nx] = true;
                            solve(x, y, sum + arr[ny][nx], count + 1);
                        visited[ny][nx] = false;
                    }

                    visited[ny][nx] = true;
                    solve(nx, ny, sum + arr[ny][nx], count + 1);
                    visited[ny][nx] = false;
                }
            }
        }
    }