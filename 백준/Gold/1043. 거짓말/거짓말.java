import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] party = new boolean[M];
        Graph graph = new Graph(N);

        st = new StringTokenizer(br.readLine());
        int numOfKnowLie = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numOfKnowLie; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int[][] partyInfo = new int[M][];
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int numOfPeople = Integer.parseInt(st.nextToken());
            int[] tempArr = new int[numOfPeople];

            for (int i = 0; i < numOfPeople; i++) {
                tempArr[i] = Integer.parseInt(st.nextToken());
            }

            partyInfo[k] = tempArr;

            for (int i = 0; i < numOfPeople; i++) {
                for (int j = i + 1; j < numOfPeople; j++) {
                    graph.addEdge(tempArr[i], tempArr[j]);
                }
            }
        }

        boolean[] visited = new boolean[N + 1];
        for (int knowTruth : set) {
            dfs(knowTruth, visited, graph);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : partyInfo[i]) {
                if (visited[person]) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int current, boolean[] visited, Graph graph) {
        if (visited[current]) {
            return;
        }

        visited[current] = true;
        for (int next : graph.adj.get(current)) {
            dfs(next, visited, graph);
        }
    }
}

class Graph {
    private int V;
    List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}