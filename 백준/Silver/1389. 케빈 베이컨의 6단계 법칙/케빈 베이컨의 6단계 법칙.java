import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] Gr = new int[N+1][N+1];
        //입력받기
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j){
                    Gr[i][j]=0;
                }
                else {
                    Gr[i][j]=987654321;
                }
            }
        }


        for(int i=0;i<M;i++){
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           Gr[x][y]=1;
           Gr[y][x]=1;
        }

        //업데이트 하기
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(Gr[i][k]+Gr[k][j]<Gr[i][j]){
                        Gr[i][j]=Gr[i][k]+Gr[k][j];
                    }
                }
            }
        }
        //출력하기
        int least = Integer.MAX_VALUE;
        int leastId=-1;
        for(int i=1;i<=N;i++){
            int sum=0;
            for(int j=1;j<=N;j++){
                sum+=Gr[i][j];
            }
            if(least>sum){
                least=sum;
                leastId=i;
            }
        }
        System.out.println(leastId);
    }
}