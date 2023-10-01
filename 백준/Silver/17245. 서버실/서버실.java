import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long numOfCom;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N*N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i*N+j] = Long.parseLong(st.nextToken());
                numOfCom += arr[i*N+j];
            }
        }

        Arrays.sort(arr);

        long start = 0;
        long end = arr[N*N-1];
        
        while(start <= end){
            long mid = (start + end) / 2;

            if(isPossible(mid)){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }

       System.out.println(start);
    }

   static boolean isPossible(long time){
       long count=0;

       for(int i=0; i<arr.length; i++){
           if(arr[i]>=time){
               count+=time;
           }else{
               count+=arr[i];
           }
       }

       return count >= (numOfCom+1)/2;
   }
}
