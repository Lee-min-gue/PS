    import java.util.*;
    import java.io.*;
    public class Main {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            char[] s = br.readLine().toCharArray();
            int pnCount=0;
            int count=0;
            for(int i=1;i<M-1;i++){
                if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I'){
                    pnCount++;
                    if(pnCount==N){
                        pnCount--;
                        count++;
                    }
                    i++;
                }
                else{
                    pnCount=0;
                }
            }
            System.out.println(count);
        }
    }