import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxDays=0;
        int M=sc.nextInt();
        int N=sc.nextInt();
        int[][]arr=new int[N][M];
        Queue<tomato>queue=new LinkedList<>();
        //add num in array
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                 arr[i][j]=sc.nextInt();
                 //add rotten tomato in queue
                 if(arr[i][j]==1){
                    queue.add(new tomato(j,i,0));
                 }
            }
        }
        while(!queue.isEmpty()){
            int[]dx={-1,1,0,0};
            int[]dy={0,0,-1,1};
            tomato tom=queue.poll();
            if(tom.day>maxDays){
                maxDays= tom.day;
            }
            for(int i=0;i<4;i++){
                int nx=tom.x+dx[i];
                int ny=tom.y+dy[i];
                if(0<=nx&&nx<M&&0<=ny&&ny<N){
                    if(arr[ny][nx]==0){
                        arr[ny][nx]=1;
                        queue.add(new tomato(nx,ny,tom.day+1));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    maxDays = -1;
                    break;
                }
                if (maxDays == -1) {
                    break;
                }
            }
        }
        System.out.println(maxDays);
    }
}
class tomato{
    int x,y,day;
    tomato(int x,int y,int day){
        this.x=x;
        this.y=y;
        this.day=day;
    }
}