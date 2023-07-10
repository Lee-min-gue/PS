import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int num[]=new int[12];
        num[1]=1;
        num[2]=2;
        num[3]=4;
        for(int i=4;i<12;i++){
            num[i]=num[i-1]+num[i-2]+num[i-3];
        }

        while (T-- != 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(num[n]);
        }
    }
}