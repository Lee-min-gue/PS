import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static  int M;
    static int[] arr = new int[10];
    static int[] nums;
    static boolean[] check;
    static Set set = new HashSet();

    static void find(int x, int len){
        if(len == M){
            String in="";
            for(int i=0; i<M; i++){
                in=in.concat(arr[i]+" ");
            }
            if(set.contains(in)){
                return;
            }
            set.add(in);
            System.out.println(in);
            return;
        }

        for(int i=0;i<N;i++){
            if(!check[i]){
                check[i] = true;
                arr[len] = nums[i];
                find(i+1,len+1);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        check = new boolean[N];


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        find(0,0);

    }
}