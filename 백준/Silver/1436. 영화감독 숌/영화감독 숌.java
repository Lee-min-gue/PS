import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int Number=0;
        int Out=0;
        int count=0;
        while(count!=N){
            String st=Integer.toString(Number);
            if(st.contains("666")){
                count++;
                Out=Number;
            }
            Number++;
        }
        System.out.println(Out);
    }
}