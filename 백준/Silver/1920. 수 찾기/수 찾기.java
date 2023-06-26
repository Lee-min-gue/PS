import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap <Integer,Integer> hashMap=new HashMap<>();
        int n=sc.nextInt();
        for (int i=0;i<n;i++) {
            int N=sc.nextInt();
           hashMap.put(N,1);
        }
        int m=sc.nextInt();
        for (int i=0;i<m;i++) {
            int M=sc.nextInt();
            if(hashMap.containsKey(M)){
                System.out.println(1);
            }
            else
                System.out.println(0);
        }
    }
}