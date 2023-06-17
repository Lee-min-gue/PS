import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ArrayList<Integer> data=new ArrayList<>();
        String input=sc.next();
        int cursor=0;
        while(cursor+1<=input.length()){
            data.add(Integer.parseInt(Character.toString(input.charAt(cursor++))));
        }
        Collections.sort(data,Collections.reverseOrder());
        Iterator iterator= data.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
}