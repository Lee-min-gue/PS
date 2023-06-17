import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfString = sc.nextInt();
        HashSet<String> strings = new HashSet<String>();
        for (int i = 0; i < numOfString; i++) {
            strings.add(sc.next());
        }
        ArrayList<String>uniqueStrings=new ArrayList<>(strings);

        Collections.sort(uniqueStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int cmp = Integer.compare(s1.length(), s2.length());
                if (cmp != 0) {
                    return cmp;
                }
                return s1.compareTo(s2);
            }
        });

        Iterator iterator= uniqueStrings.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}