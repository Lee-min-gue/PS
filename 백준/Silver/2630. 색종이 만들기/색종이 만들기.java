import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int arr[][];
    static int white;
    static int blue;
    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            arr= new int[N][N];
            white=0;
            blue=0;

            //색종이 입력하기
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(data[j]);
                }
            }
            //검사하기
            squares(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void squares(int x,int y,int size){
        int flag = arr[y][x];
        int newSize=size/2;
        for (int i = y; i < size + y; i++) {
            for(int j = x; j < size + x; j++){
                if(flag!=arr[i][j]){
                    squares(x,y,newSize);
                    squares(x+newSize,y,newSize);
                    squares(x,y+newSize,newSize);
                    squares(x+newSize,y+newSize,newSize);
                    return;
                }
            }
        }
        if(flag==0){
            white++;
        }
        else{
            blue++;
        }
    }
}