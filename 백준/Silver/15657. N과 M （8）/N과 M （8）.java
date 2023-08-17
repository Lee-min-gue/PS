import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static  int M;
    static int[] arr = new int[10];
    static int[] nums;

    static void find(int x, int len){
        if(len == M){
            for(int i= 0; i<M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=x;i<N;i++){
            arr[len] = nums[i];
            find(i,len+1);
        }
    }


    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      nums = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
          nums[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(nums);
      find(0,0);
    }
}






















