import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int TestCase=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<TestCase;i++){
            String st=sc.nextLine();
            Stack<Character> stack=new Stack<>();
            Stack<Character> stackForJudge=new Stack<>();
            for(int j=0;j<st.length();j++){
                stack.push(st.charAt(j));
            }
            while(!stack.isEmpty()){
                char temp=stack.pop();
                if(stackForJudge.isEmpty()){
                    stackForJudge.push(temp);
                    continue;
                }
                else {
                    if(temp=='('&&stackForJudge.peek()==')'){
                        stackForJudge.pop();
                    }
                    else stackForJudge.push(temp);
                }
            }
            if(!stackForJudge.isEmpty()){
                System.out.println("NO");
            }
            else System.out.println("YES");
        }
    }
}