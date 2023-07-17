import java.util.*;
import java.io.*;
 
 
public class Main {
 
    static int [] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        System.out.println(solve(n));
    }
 
    public static int solve(int num){
 
        for(int i=2;i<=num; i++){
            int min = Integer.MAX_VALUE;
 
            for(int j=1; j*j<=i; j++){
                min=Math.min(min, dp[i-j*j]);
            }
 
            dp[i]=min+1;
        }
 
        return dp[num];
    }
}