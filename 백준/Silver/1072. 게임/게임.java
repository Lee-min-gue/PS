import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long X = scan.nextLong(); // 게임 횟수
        long Y = scan.nextLong(); // 이긴 게임

        long Z = 100*Y/X; // 승률 (소수점 버림)

        if(Z >= 99) { // 승률이 99 이상이면 더 이상 상승하지 않음
            System.out.println(-1);
            return;
        }

        long low = 0, high = X;

        while(low <= high) {
            long mid = (low + high) / 2;
            long tempZ = 100*(Y+mid)/(X+mid);

            if(Z < tempZ) { // 승률이 상승하면 범위를 줄여나감
                high = mid - 1;
            } else { // 승률이 그대로면 범위를 늘림
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
