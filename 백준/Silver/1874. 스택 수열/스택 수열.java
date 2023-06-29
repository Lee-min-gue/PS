import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int currentIndex = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");

            while (!stack.empty() && stack.peek() == arr[currentIndex]) {
                stack.pop();
                sb.append("-\n");
                currentIndex++;
            }
        }

        if (stack.empty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}