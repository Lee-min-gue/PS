import java.util.Scanner;

public class Main {
    public static int factorial(int a){
       if (a==0||a==1){
           return 1;
       }
       else{
           return factorial(a-1)*a;
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
}
