import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static int N;
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();
        String[] nameArr = new String[N + 1];
        HashMap map=new HashMap<>();


        for(int i=1;i<=N;i++){
            String st=sc.nextLine();
            map.put(st,i);
            nameArr[i]=st;
        }

        for(int i=1;i<=M;i++){
            String current=sc.nextLine();
            if(isStringNumber(current)){
                System.out.println(nameArr[Integer.parseInt(current)]);
            }
            else {
               System.out.println(map.get(current));
            }
        }
    }
    public static boolean isStringNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}