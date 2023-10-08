import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] numbers = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> lis = new ArrayList<>();
        lis.add(numbers[0]);

        for(int i=1; i<N; i++){
            if(lis.get(lis.size()-1) < numbers[i]){
                lis.add(numbers[i]);
            } else {
                int idx = binarySearch(0, lis.size()-1, numbers[i], lis);
                lis.set(idx, numbers[i]);
            }
        }

        System.out.println(lis.size());
    }

    public static int binarySearch(int left, int right, int target, List<Integer> list){
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
