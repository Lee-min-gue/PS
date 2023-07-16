import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<point> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        ArrayList<Integer> map = new ArrayList<>();
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        int nowNum = 1;

        // 입력받기
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.charAt(j) - '0';
            }
        }

        // 순회하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == true || arr[i][j] != 1) {
                    continue;
                }
                queue.add(new point(j, i));
                visited[i][j] = true;
                int numnum = 0;
                while (!queue.isEmpty()) {
                    point current = queue.poll();
                    numnum++;
                    visited[current.y][current.x] = true;
                    arr[current.y][current.x] = nowNum;
                    for (int k = 0; k < 4; k++) {
                        int nx = current.x + dx[k];
                        int ny = current.y + dy[k];
                        if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) {
                            continue;
                        }
                        if (visited[ny][nx] == true || arr[ny][nx] != 1) {
                            continue;
                        }
                        queue.add(new point(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
                map.add(numnum);
                nowNum++;
            }
        }

        // 출력하기
        Collections.sort(map);
        System.out.println(nowNum - 1);
        for (Integer key : map) {
            System.out.println(key);
        }
        br.close();
    }
}

class point {
    int x;
    int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}