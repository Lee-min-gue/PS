 import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int L=sc.nextInt();
            String string=sc.next();
            int sum=0;
            for(int i=0;i<L;i++){
                int out=(string.charAt(i)-96);
                for(int k=0;k<i;k++){
                    out*=31;
                }
                sum+=out;
            }
            System.out.println(sum);
        }
    }
