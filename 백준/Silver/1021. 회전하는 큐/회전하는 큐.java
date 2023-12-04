import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            while (true) {
                int index = ((LinkedList<Integer>) queue).indexOf(target);
                int left = index;
                int right = queue.size() - index;
                if (index == 0) {
                    queue.poll();
                    break;
                }
                if (left <= right) {
                    queue.add(queue.poll());
                    count++;
                } else {
                    ((LinkedList<Integer>) queue).addFirst(((LinkedList<Integer>) queue).removeLast());
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
