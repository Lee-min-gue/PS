#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

static int N,M;
static int least = INT_MAX;
vector<vector<int>> arr;
vector<vector<int>> visited;
static int dx[4] = {-1, 1, 0, 0};
static int dy[4] = {0, 0, -1, 1};

struct point {
    int x, y, time, blockCrashed;
    point(int x, int y, int time, int blockCrashed) : x(x), y(y), time(time), blockCrashed(blockCrashed) {}
};

void bfs(int x, int y) {
    queue<point> q;
    q.push(point(x, y, 1, 0));
    visited[y][x] = 0;

    while (!q.empty()){
        point current = q.front();
        q.pop();

        if(current.y == N-1 && current.x == M-1){
            least = current.time;
            break;
        }

        for (int i = 0; i < 4; i++) {
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];

            if (!(0 <= nx && nx < M && 0 <= ny && ny < N) || visited[ny][nx] <= current.blockCrashed) {
                continue;
            }

            if(arr[ny][nx] == 0){
                visited[ny][nx] = current.blockCrashed;
                q.push(point(nx, ny, current.time+1, current.blockCrashed));
            }
            else{
                if(current.blockCrashed == 0){
                    visited[ny][nx] = current.blockCrashed+1;
                    q.push(point(nx, ny, current.time+1, current.blockCrashed+1));
                }
            }
        }
    }
}

int main() {
    cin >> N >> M;
    arr = vector<vector<int>>(N, vector<int>(M));
    visited = vector<vector<int>>(N, vector<int>(M, INT_MAX));

    //Initialize array
    for(int i=0; i<N; i++){
        string str;
        cin >> str;
        for(int j=0; j<M;j++){
            arr[i][j] = str[j]-'0';
        }
    }

    bfs(0,0);
    cout << (least == INT_MAX ? -1 : least) << endl;

    return 0;
}
