import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String st = br.readLine();
        String[] str = st.split(" ");
        long[] arr= new long[N];
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(str[i]);
        }

        Arrays.sort(arr);

        int start=0;
        int end=N-1;
        long min=Long.MAX_VALUE;
        int resStart=start;
        int resEnd=end;

        while (start<end){
            long hap =arr[start]+arr[end];

            if(min>Math.abs(hap)){
                min=Math.abs(hap);
                resStart = start;
                resEnd = end;
            }

            if(hap<0){
                start++;
            }
            else if(hap>0){
                end--;
            }
            else{
                break;
            }
        }
        System.out.println(arr[resStart]+" "+arr[resEnd]);
    }
}
