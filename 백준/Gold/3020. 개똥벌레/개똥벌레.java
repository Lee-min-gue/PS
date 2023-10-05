import java.util.Scanner;

public class Main {
    static int N, H;
    static int[] top, bottom;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        H = scanner.nextInt();
        top = new int[H+1];
        bottom = new int[H+1];

        for(int i=0; i<N; i++) {
            int h = scanner.nextInt();

            if(i % 2 == 0)
                bottom[h]++;
            else
                top[H - h + 1]++;
        }

        for(int i=1; i<=H; i++)
            top[i] += top[i-1];

        for(int i=H-1; i>=0; i--)
            bottom[i] += bottom[i+1];


        long ans = Long.MAX_VALUE;
        int cnt = 0;

        for(int i=1; i<=H; i++) {
            if(top[i] + bottom[i] < ans){
                cnt = 1;
                ans = top[i] + bottom[i];
            }

            else if(top[i] + bottom[i] == ans)
                cnt++;

        }

        System.out.println(ans + " " + cnt);

        scanner.close();
    }
}
