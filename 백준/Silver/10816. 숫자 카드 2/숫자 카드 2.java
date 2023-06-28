import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
       int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int M=sc.nextInt();
        StringBuilder stringBuilder=new StringBuilder();
        for(int j=0;j<M;j++){
            int m=sc.nextInt();
            stringBuilder.append(upperBound(arr,m)-lowerBound(arr,m)).append(' ');

        }
        System.out.println(stringBuilder);
    }
    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {

            int mid = (lo + hi)/2;
            if (key <= arr[mid]) {
                hi = mid;
            }

            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}