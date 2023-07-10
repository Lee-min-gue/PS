import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int absO1=Math.abs(o1);
                int absO2=Math.abs(o2);
                if (absO1 == absO2) {
                    // 절대값이 동일하면 원래 숫자를 기준으로 비교
                    return Integer.compare(o1, o2);
                }
                return Integer.compare(absO1, absO2);
            }
        });
        while (N--!=0){
            int order=Integer.parseInt(br.readLine());
            if(order==0){
                if(priorityQueue.isEmpty()){
                    System.out.println("0");
                }
                else {
                    System.out.println(priorityQueue.poll());
                }
            }
            else {
                priorityQueue.add(order);
            }
        }
    }
}