import java.io.*;
import java.util.*;

public class Main {
    static int N,L,W,H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        L = Integer.parseInt(st[1]);
        W = Integer.parseInt(st[2]);
        H = Integer.parseInt(st[3]);

        double start=0;
        double end=Math.max(L, Math.max(W, H));

        for(int i=0;i<10000;i++){ // enough precision for this problem
            double mid=(start+end)/2;
            if((long)(L/mid)*(long)(W/mid)*(long)(H/mid)>=N)
                start=mid;
            else
                end=mid;

        }
        System.out.printf("%.10f\n", start);
    }
}