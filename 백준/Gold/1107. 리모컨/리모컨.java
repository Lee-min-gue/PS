import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetChannel=sc.nextInt(); //Number of Target channel
        String targetString=Integer.toString(targetChannel);//타겟넘버의 문자열
        int targetLength=targetString.length();             //타겟넘버의 자리수
        int errorButtonNum= sc.nextInt();                   //고장난 버튼의 개수
        int buttonClickUp=targetChannel;            //target 초과하고 가장 가까운수
        int clickOne=0;
        int buttonClickDown=targetChannel;          //target 미만이고 가장 가까운수 찾기
        int clickTwo=0;
        int JustClick=Math.abs(targetChannel-100);                  //클릭만으로 찾기
        String[] button=new String[errorButtonNum];         //고장난 버튼들을 저장하는 배열
        for (int i = 0; i < errorButtonNum; i++) {
            int errorButton = sc.nextInt();
            button[i] = Integer.toString(errorButton);
        }
        while (true){
            if(Check(Integer.toString(buttonClickUp),button)==true)
                break;
            else {
                buttonClickUp++;
                clickOne++;
                if(clickOne>=JustClick){
                    break;
                }
            }
        }
        while (true){
            if(Check(Integer.toString(buttonClickDown),button)==true)
                break;
            else {
                buttonClickDown--;
                clickTwo++;
                if(clickTwo>=JustClick){
                    break;
                }
            }
        }
        clickOne+=Integer.toString(buttonClickUp).length();
        clickTwo+=Integer.toString(buttonClickDown).length();
        System.out.println(Math.min(JustClick,Math.min(clickOne,clickTwo)));
    }
    public static boolean Check(String string,String[] arr){
        for(String cursor:arr){
            if(string.contains(cursor)){
                return false;
            }
        }
        return true;
    }
}