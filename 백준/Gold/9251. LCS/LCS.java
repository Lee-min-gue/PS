import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st1 = bf.readLine();
        String st2 = bf.readLine();

        int[][] dp = new int[st1.length()+1][st2.length()+1];
        for(int i=1;i<=st1.length();i++){
            char ch1 = st1.charAt(i-1);
            for (int j=1;j<=st2.length();j++){
                char ch2 = st2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[st1.length()][st2.length()]);
    }
}
