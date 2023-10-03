import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N,L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String[] str = st.split(" ");
        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        int[] location = new int[N];
        int[] weight = new int[N];


        st = br.readLine();
        str = st.split(" ");
        for(int i=0;i<N;i++){
            location[i] = Integer.parseInt(str[i]);
        }

        st = br.readLine();
        str = st.split(" ");
        for(int i=0;i<N;i++){
            weight[i] = Integer.parseInt(str[i]);
        }

        double first=0, back=L;
        double mid=0;

        while(Math.abs(back-first)>1e-8){
            double leftWeight=0,rightWeight=0;
            mid=(first+back)/2;
            for(int i=0; i<N; ++i){
                if(location[i]<=mid)
                    leftWeight+=weight[i]*(mid-location[i]);
                else
                    rightWeight+=weight[i]*(location[i]-mid);
            }

            if(leftWeight<rightWeight)
                first=mid;
            else
                back=mid;
        }
        System.out.printf("%f\n",mid);
    }
}
