import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int A, B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextInt();
        B = scanner.nextInt();

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<A+B;i++){
            int input = scanner.nextInt();
            if(set.contains(input)){
                set.remove(input);
            }
            else{
                set.add(input);
            }
        }

        System.out.println(set.size());

        scanner.close();
    }
}
