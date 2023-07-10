import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        if (N == K) {
            System.out.println(0);
            return;
        }

        final int MAX = 100001;
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int[] moves = { cur * 2, cur + 1, cur - 1 };
            
            for (int next : moves) {
                if (next < 0 || next >= MAX) continue;

                if (dist[next] == -1 || dist[next] > dist[cur] + 1) {
                    queue.add(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
        
        System.out.println(dist[K]);
    }
}