import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      Deque<int[]> deque = new ArrayDeque<>(); //[0] is data, [1] is index

      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int L = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++){
          int num = Integer.parseInt(st.nextToken());
          while (!deque.isEmpty() && deque.peekLast()[0] > num) deque.pollLast();

          deque.offer(new int[]{num,i});

          if(deque.peek()[1] < i-(L-1)){
              deque.poll();
          }
          bw.write(deque.peek()[0]+" ");
      }
      bw.flush();
      bw.close();
    }
}