import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        System.out.println(factorial(n) / (factorial(k)*factorial(n-k)));
    }

    public static int factorial(int n){
        int out=1;
        while (n!=0){
            out*=n--;
        }
        return out;
    }
}