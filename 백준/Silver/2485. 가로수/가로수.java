import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] treePositions = new int[N];

        for (int i = 0; i < N; i++) {
            treePositions[i] = sc.nextInt();
        }

        int gcdValue = treePositions[1] - treePositions[0];
        
        for (int i = 2; i < N; i++) {
            gcdValue = gcd(gcdValue, treePositions[i] - treePositions[i - 1]);
        }

        int answer = 0;
        
        for (int i=1; i<N; ++i) 
            answer += ((treePositions[i] - treePositions[i-1]) / gcdValue) - 1;
            
        
         System.out.println(answer);
    }
    
    // 유클리드 호제법을 사용하여 최대공약수 계산
    public static int gcd(int a, int b){
       if(b == 0)
           return a;
       else
           return gcd(b, a % b);
   }
}
