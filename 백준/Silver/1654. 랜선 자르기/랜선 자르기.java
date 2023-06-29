import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();
        int N=sc.nextInt();

        int[]k=new int[K];
        long max=0;
        long min=1;
        long mid=0;
        for(int i=0;i<K;i++){
            k[i]=sc.nextInt();
            max = Math.max(max,k[i]);
        }
        while(max>=min){
            mid=min+(max-min)/2;
            if(isOverN(mid,N,K,k)){
                min=mid+1;
            }
            else{
                max=mid-1;
            }
        }
        System.out.println(min-1);

    }
    public static boolean isOverN(long pivot,int N,int K,int[]arr){
        int numOfCable=0;
        for(int i=0;i<K;i++){
            numOfCable+=arr[i]/pivot;
        }
        if(numOfCable>=N){
            return true;
        }
        else return false;
    }
}
