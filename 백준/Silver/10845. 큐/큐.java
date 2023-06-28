import java.util.Scanner;
public class Main {

    public static int[] queue;
    public static int size = 0;
    static int front = 0;
    static int back = -1; // 수정된 부분

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        queue = new int[N];

        for (int i = 0; i < N; i++) {

            String str = in.next();

            switch (str) {

                case "push":
                    push(in.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n'); // 수정된 부분
                    break;

                case "back":
                    sb.append(back()).append('\n'); // 수정된 부분
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int item) {
        queue[++back] = item; // 수정된 부분
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int res = queue[front];
            queue[front] = 0;
            size--;
            front++;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() { // 추가된 부분
        if (size == 0) {
            return -1;
        } else {
            return queue[front];
        }
    }

    public static int back() { // 추가된 부분
        if (size == 0) {
            return -1;
        } else {
            return queue[back];
        }
    }
}