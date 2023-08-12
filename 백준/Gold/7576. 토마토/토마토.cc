#include<iostream>
#include<queue>
using namespace std;

class Tomato {
private:
    int x;
    int y;
public:
    Tomato(int x, int y) : x(x), y(y) { }
    Tomato(const Tomato& other) : x(other.x), y(other.y) { }
    int get_x() const { return x; }
    int get_y() const { return y; }
};

int main() {
    int M, N;
    int Max = 0;
    queue<Tomato> q;
    int dx[] = { 1,-1,0,0 };
    int dy[] = { 0,0,1,-1 };

    cin >> M >> N;
    
    //create array
    int** array = new int* [N];
    bool** visited = new bool* [N];
    for (int i = 0; i < N; i++) {
        array[i] = new int[M];
        visited[i] = new bool[M];
    }

    //initialize array
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> array[i][j];
            if (array[i][j] == 1) {
                q.push(Tomato(j, i));
                visited[i][j] = true;
            }
        }
    }

    //bfs    
    while (!q.empty()) {
        Tomato temp = q.front();
        q.pop();    
        for (int k = 0; k < 4; k++) {
            int nx = temp.get_x() + dx[k];
            int ny = temp.get_y() + dy[k];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx] == true || array[ny][nx] == -1) continue;
            array[ny][nx] = array[temp.get_y()][temp.get_x()] + 1;
            visited[ny][nx] = true;
            q.push(Tomato(nx, ny));
        }
    }

    //find Max value
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (array[i][j] == 0) {
                cout << -1 << endl;
                return 0;
            }
            else if (array[i][j] > Max) {
                Max = array[i][j];
            }
        }
    }

    cout << Max - 1 << endl; // 1부터 시작했으므로 결과에서 1을 뻅니다.

    //delete array
    for (int i = 0; i < N; i++) {
        delete[] array[i];
        delete[] visited[i];
    }
}
