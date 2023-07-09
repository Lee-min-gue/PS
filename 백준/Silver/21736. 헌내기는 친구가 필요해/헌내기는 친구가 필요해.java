import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(); //세로
        int M=sc.nextInt(); //가로
        int count=0;
        Queue queue=new LinkedList();
        person me=new person(0,0);
        char[][] arr = new char[N][M];
        int[][] visited = new int[N][M];
        sc.nextLine(); // 입력 버퍼 지우기

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if(line.charAt(j)=='I'){
                    me=new person(j,i);
                }
            }
        }

        //사람찾기 시작
        queue.add(me);
        while(!queue.isEmpty()){
            int[]dx={-1,1,0,0};
            int[]dy={0,0,-1,1};
            person current=(person) queue.poll();
            for(int i=0;i<4;i++){
                int nx=current.x+dx[i];
                int ny=current.y+dy[i];
                if(0<=nx&&nx<M&&0<=ny&&ny<N&&arr[ny][nx]!='X'){
                    if(visited[ny][nx]==0){
                        if(arr[ny][nx]=='P'){
                            count++;
                        }
                        queue.add(new person(nx,ny));
                        visited[ny][nx]=1;
                    }
                }
            }
        }
        if(count==0){
            System.out.println("TT");
        }
        else {
            System.out.println(count);
        }
    }
}

class person{
    int x;
    int y;
    person(int x,int y){
        this.x=x;
        this.y=y;
    }
}