import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a] = b - a;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a] = b - a;
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        queue.add(1);
        countQueue.add(0);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int location = queue.poll();
            int count = countQueue.poll();

            if (location == 100) {
                System.out.println(count);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nextLocation = location + i;
                if (nextLocation <= 100) {
                    int modifiedLocation = nextLocation + arr[nextLocation];

                    if (!visited[nextLocation]) {
                        if (arr[nextLocation] != 0) {
                            queue.add(modifiedLocation);
                        } else {
                            queue.add(nextLocation);
                        }
                        countQueue.add(count + 1);
                        visited[nextLocation] = true;
                    }
                }
            }
        }
    }
}

