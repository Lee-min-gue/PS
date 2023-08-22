import java.util.*;
import java.io.*;
public class Main {
    static final int INF = 987654321;
    static int V,E,K;
    static ArrayList<ArrayList<int[]>> graph;
    static int[] Dist;

    static void dijkstra(int src){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[] visited  = new boolean[V+1];
        for(int i=1; i<=V; i++){
            Dist[i]=INF;
        }
        Dist[src] = 0;
        pq.add(new int[]{0,src});

        while (!pq.isEmpty()){
            int[] curr= pq.poll();
            int u = curr[1];
            if(visited[u]) continue;

            visited[u] = true;
            for(int[] edge : graph.get(u)){
                int v = edge[0];
                int w = edge[1];
                if(Dist[v]>Dist[u] + w){
                    Dist[v] = Dist[u] + w;
                    pq.add(new int[]{Dist[v],v});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(bf.readLine());
        graph = new ArrayList<>();
        Dist = new int[V+1];

        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, cost});
        }
        dijkstra(K);

        for(int i=1; i<=V; i++){
            if (Dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(Dist[i]);
        }
    }
}
