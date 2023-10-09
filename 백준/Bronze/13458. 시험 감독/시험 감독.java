import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        String[] str = bf.readLine().split(" ");
        int B = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);

        long count = 0;

        for(int i=0;i<N;i++){
            count++;
            arr[i]-=B;
            if(arr[i]>0){
                count+=arr[i]/C;
                if(arr[i]%C!=0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
