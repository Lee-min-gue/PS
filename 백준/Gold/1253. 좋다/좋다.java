import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int countGood = 0;
        int[]arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
           arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            int left = 0;
            int right = N-1;
            while (true){
                if(left==i){
                    left++;
                }
                else if(right==i){
                    right--;
                }

                if(left>=right){
                    break;
                }

                if(arr[left]+arr[right]>arr[i]){
                    right--;
                }
                else if(arr[left]+arr[right]>arr[i]){
                    left++;
                }
                else if(arr[left]+arr[right]==arr[i]){
                    countGood++;
                    break;
                }
                else{left++;}
            }
        }
        System.out.println(countGood);
     }
}