import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
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