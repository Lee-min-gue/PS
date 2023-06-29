    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N;
            int M;
            int B;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][M];
            int maxHeight = 0;
            int minHeight = 256;
            // 현재 땅 입력 받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] > maxHeight) {
                        maxHeight = arr[i][j];
                    }
                    if (arr[i][j] < minHeight) {
                        minHeight = arr[i][j];
                    }
                }
            }

            int bestTime = -1;
            int bestBlockHeight = 0;
            int[] safeNum=new int[maxHeight-minHeight+1];
            int cursor=0;
            int count=0;


            //블록의 개수가 안전한 기준 케이스 찾기
            for(int i = minHeight; i <= maxHeight; i++){
                int sumOfBlock=0;
                for (int k = 0; k < N; k++) {
                    for (int j = 0; j < M; j++) {
                        if (arr[k][j] > i) {
                            sumOfBlock+=arr[k][j]-i;
                        }
                        else if (arr[k][j] < i) {
                            sumOfBlock-=i-arr[k][j];
                        }
                    }
                }
                if(sumOfBlock+B>=0){
                    safeNum[cursor++]=i;
                    count++;
                }
            }
            if(minHeight==maxHeight){
                System.out.println("0 "+safeNum[0]);
                return;
            }
            //안전한 기준으로 시간,블록 계산
            for (int i=0;i<count;i++) {
                int time=0;
                for (int k = 0; k < N; k++) {
                    for (int j = 0; j < M; j++) {
                        if(arr[k][j]<safeNum[i]){
                            time+=safeNum[i]-arr[k][j];
                        }
                        else if(arr[k][j]>safeNum[i]){
                            time+=(arr[k][j]-safeNum[i])*2;
                        }
                    }
                }
                if(bestTime==-1){
                    bestTime=time;
                    bestBlockHeight=safeNum[i];
                }
                else if(time<=bestTime){
                    bestTime=time;
                    bestBlockHeight=safeNum[i];
                }
            }
            System.out.println(bestTime + " " + bestBlockHeight);
        }
    }