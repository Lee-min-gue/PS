import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine(); // 제거되지 않은 줄바꿈 문자를 처리합니다.
        for (int i = 0; i < testCase; i++) {
            f(sc);
        }
    }
    public static void f(Scanner sc) {
        String order = sc.nextLine();
        int num = sc.nextInt();
        boolean isReversed=false;
        sc.nextLine(); // 제거되지 않은 줄바꿈 문자를 처리합니다.
        String input = sc.nextLine();
        input = input.replaceAll("[^\\d,]", "");
        String[] strArray = input.split(",");
        Deque<Integer> queue = new ArrayDeque<>();
        for (String str : strArray) {
            // 빈 배열이 아닐 때만 정수로 변환하고 큐에 추가합니다.
            if (!str.isEmpty()) {
                queue.add(Integer.parseInt(str));
            }
        }
        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i) == 'D') {
                if (queue.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                else if(!isReversed){
                    queue.poll();
                }
                else {
                    queue.pollLast();
                }
            }
            else if (order.charAt(i) == 'R') {
               isReversed=!isReversed;
            }
        }
        if (queue.isEmpty()) {
            System.out.println("[]");
            return;
        }
        if(!queue.isEmpty()){
                if (isReversed){
                    Iterator<Integer> descendingIterator = queue.descendingIterator();
                    Deque<Integer> reversedDeque = new ArrayDeque<>();
                    while (descendingIterator.hasNext()) {
                        reversedDeque.add(descendingIterator.next());
                    }
                    System.out.println(reversedDeque.toString().replaceAll(" ",""));
                }
                else{
                    System.out.println(queue.toString().replaceAll(" ",""));
                }
        }
    }
}
