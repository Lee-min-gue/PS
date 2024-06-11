import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if (s<n)
            return answer;
        
        answer = new int [n];
        int a = s/n;
        int b = s%n;
        
        for (int i=0; i<n; i++) {
            answer[i] = a;
        }
        
        for (int i=0;i<b; i++) {
                answer[n-1-i]++;
        }
        
        return answer;
        
    }
}