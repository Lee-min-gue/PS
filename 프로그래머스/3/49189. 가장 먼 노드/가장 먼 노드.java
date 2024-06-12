import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] node:edge) {
            int a = node[0];
            int b= node[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int neighbor: graph.get(node)) {
                if(distance[neighbor] == -1) {
                    distance[neighbor] = distance[node]+1;
                    q.offer(neighbor);
                }
            }
        }

        int maxDis = 0;
        for (int dis : distance) {
            maxDis = Integer.max(maxDis, dis);
        }
        
        for (int num : distance) {
            if (num == maxDis) answer++;
        }
        return answer;
    }
}