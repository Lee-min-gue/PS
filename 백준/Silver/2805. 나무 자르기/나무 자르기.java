    import java.util.*;
    import java.io.*;
    public class Main {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int big=0;
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                big=Math.max(big,arr[i]);
            }

            int start=0;
            int end = big;
            int middle;
            while (start<end){
               middle=(start+end)/2;
                long sum=0;
                for(int i=0;i<N;i++){
                    if(arr[i]-middle>0){
                        sum+=arr[i]-middle;
                    }
                }
                if(sum<M){
                    end=middle;
                }
                else {
                    start=middle+1;
                }
            }
            System.out.println(start-1);
        }
    }