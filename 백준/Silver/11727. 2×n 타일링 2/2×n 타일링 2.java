import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[1001];
        arr[1]=1;
        arr[2]=3;
        for(int i=3;i<=1000;i++){
            arr[i]=(arr[i-1]+arr[i-2]*2)%10007;
        }
        System.out.println(arr[N]);
        br.close();
    }
}