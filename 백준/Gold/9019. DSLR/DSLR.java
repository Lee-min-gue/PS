import java.util.*;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            String[] answer = new String[10000];
            Arrays.fill(answer,"");
            queue.add(n);
            visited.add(n);
            while (!queue.isEmpty()&&!visited.contains(m)) {
                int now = queue.poll();
                int D = (2 * now) % 10000;
                int S = (now == 0) ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;
                if (!visited.contains(D)) {
                    visited.add(D);
                    queue.add(D);
                    answer[D] = answer[now] + "D";
                }
                if (!visited.contains(S)) {
                    visited.add(S);
                    queue.add(S);
                    answer[S] = answer[now] + "S";
                }
                if (!visited.contains(L)) {
                    visited.add(L);
                    queue.add(L);
                    answer[L] = answer[now] + "L";
                }
                if (!visited.contains(R)) {
                    visited.add(R);
                    queue.add(R);
                    answer[R] = answer[now] + "R";
                }

            }
            System.out.println(answer[m]);
        }
    }
}