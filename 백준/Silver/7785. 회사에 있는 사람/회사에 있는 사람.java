    import java.util.*;
    import java.io.*;
    public class Main {

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            TreeSet<String> set = new TreeSet();
            int n = Integer.parseInt(br.readLine());


            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String inOut = st.nextToken();
                if(inOut.equals("enter")){
                    set.add(name);
                }
                else{
                    set.remove(name);
                }
            }

            Iterator iterator = set.descendingIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }