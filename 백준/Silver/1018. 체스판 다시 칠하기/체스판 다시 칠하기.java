import java.util.*;
class Main {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int m,n;

    m=sc.nextInt();
    n= sc.nextInt();
    //저장용 배열
    boolean[][]arr=new boolean[m][n];
    //검사해야하는 위치
    int M=m-7;
    int N=n-7;
    int Min=64;

    //배열 입력
    for(int i=0;i<m;i++){
        String Input=sc.next();
        for(int j=0;j<n;j++){
            if(Input.charAt(j)=='W')
                arr[i][j]=false;
            else
                arr[i][j]=true;
        }
    }
    //배열을 검사
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                int k=Check(arr,i,j);
                Min=Math.min(Min,k);
            }
        }
        System.out.println(Min);
    }
    //바꿔야하는 타일의 수를 세는 메서드
    static int Check(boolean arr[][],int startM,int startN){
        boolean flag=!arr[startM][startN];
        int count=0;
        //검사하기
        for(int i=startM;i<startM+8;i++){
            for(int j=startN;j<startN+8;j++){
                if(flag==arr[i][j]){
                    count++;
                    flag=!flag;
                }
                else {
                    flag=arr[i][j];
                }
            }
            flag=!flag;
        }
        return Math.min(count,64-count);
    }
}