    import java.util.*;
    import java.io.*;
    public class Main {
        static TreeSet<String> set;
        static String S;
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            set = new TreeSet();
            S = br.readLine();
            int len = S.length();
            for(int i=1;i<=len;i++){
                addString(i);
            }
            System.out.println(set.size());
        }

        public static void addString(int len){
            for(int i=0;i<=S.length()-len;i++){
                String newStr = S.substring(i,i+len);
                set.add(newStr);
            }
        }
    }