    import java.util.*;
    import java.io.*;
    public class Main {

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            HashSet<Integer> set = new HashSet();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer str = new StringTokenizer(br.readLine());

            for(int i=0;i<N;i++){
                set.add(Integer.parseInt(str.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
             str = new StringTokenizer(br.readLine());

            for(int i=0;i<M;i++){
                if(set.contains(Integer.parseInt(str.nextToken()))){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }

            }
        }
    }