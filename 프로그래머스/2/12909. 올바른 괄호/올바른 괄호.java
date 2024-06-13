import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        System.out.println(s);
        Stack<Character> st = new Stack();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(!st.isEmpty()) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
            else {
                st.add(c);
            }
        }
        if (st.isEmpty()) answer = true;

        return answer;
    }
}