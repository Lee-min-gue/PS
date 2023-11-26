import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sy = sc.nextInt();
        int sm = sc.nextInt();
        int sd = sc.nextInt();
        int ey = sc.nextInt();
        int em = sc.nextInt();
        int ed = sc.nextInt();

        long ans = 0;
        for(int i=sy; i<ey; i++)
            if(leap(i)) ans += 366;
            else ans += 365;

        for(int i=1; i<sm; i++) {
            if(i==2 && leap(sy)) ans--;
            ans -= month[i-1];
        }
        ans -= sd;

        for(int i=1; i<em; i++) {
            if(i==2 && leap(ey)) ans++;
            ans += month[i-1];
        }
        ans += ed;

        if(ans >= 365243) System.out.println("gg");
        else System.out.printf("D-%d\n", ans);
    }

    static boolean leap(int y) {
        return (y%4==0 && y%100!=0) || y%400==0;
    }
}
