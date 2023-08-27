import java.util.*;

 class InfixToPostfix {
    // 연산자 우선순위 확인
    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // 중위 표기법을 후위 표기법으로 변환
    public String infixToPostfix(String expression) {

        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);

            // 오퍼랜드이면 바로 추가
            if (Character.isLetterOrDigit(c))
                result += c;

                // 여는 괄호이면 스택에 추가
            else if (c == '(')
                stack.push(c);

                // 닫는 괄호이면 여는 괄호가 나올 때까지 pop
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression";
                else
                    stack.pop();

            } else { // 연산자인 경우
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        System.out.println(infixToPostfix.infixToPostfix(st));
    }
}