import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        long sum=4;
        int count=1;
        while (true) {
            if(count==n){
            System.out.println(sum);
            break;
        }
            sum+=4;
            count++;
        }
    }
}