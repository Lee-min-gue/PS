import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int command = scanner.nextInt();
            if (command == 2) {
                if (stack.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(stack.pop()).append("\n");
                }
            } else if (command == 3) {
                result.append(stack.size()).append("\n");
            } else if (command == 4) {
                result.append(stack.isEmpty() ? "1\n" : "0\n");
            } else if (command == 5) {
                if (stack.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(stack.peek()).append("\n");
                }
            } else if (command == 1) {
                stack.push(scanner.nextInt());
            }
        }
        System.out.print(result);
        scanner.close();
    }
}
