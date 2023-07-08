import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        Queue queue=new LinkedList();
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};


        for(int y=0;y<2;y++){
            int count=0;
            int arrCheck[][]=new int[N][N];
            if(y==1){
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        arrCheck[i][j]=0;
                        if(arr[i][j]=='R'){
                            arr[i][j]='G';
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (arrCheck[i][j] == 0) {
                        queue.add(new RGB(arr[i][j], j, i));
                        count++;
                    }
                    else {
                        continue;
                    }

                    while (!queue.isEmpty()) {
                        RGB current = (RGB) queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = current.x + dx[k];
                            int ny = current.y + dy[k];

                            if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) {
                                continue;
                            }

                            if (arrCheck[ny][nx] == 0) {
                                if (arr[i][j] == arr[ny][nx]) {
                                    arrCheck[ny][nx] = count;
                                    queue.add(new RGB(arr[ny][nx], nx, ny));
                                }
                            }
                        }
                    }
                }
            }
            if (y == 0) {
                System.out.print(count + " ");
            } else {
                System.out.println(count);
            }
        }
    }
}
class RGB{
    char rgb;
    int x;
    int y;
    RGB(char rgb,int x,int y){
        this.rgb=rgb;
        this.x=x;
        this.y=y;
    }
}