import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line=br.readLine()).equals("#")) {
            int count = 0;
            for (char ch : line.toCharArray()) {
                switch (Character.toLowerCase(ch)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        count++;
                        break;
                }
            }
            System.out.println(count);
        }
    }
}
