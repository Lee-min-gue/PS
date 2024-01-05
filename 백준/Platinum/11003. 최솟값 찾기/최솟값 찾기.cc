#include <iostream>
#include <deque>
#include <vector>
using namespace std;

int main() {

    //입출력 최적화
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    //입력부
    int n,l;
    cin >> n >> l;
    vector<int> a(n);

    for(int i=0;i<n;i++){
        cin >> a[i];
    }

    //해결부
    deque<pair<int, int>> dq;

    for(int i=0;i<n;i++){
        while (!dq.empty() && dq.back().first > a[i])
            dq.pop_back();

        dq.push_back({a[i],i});

        while (!dq.empty() && dq.front().second <= i-l)
            dq.pop_front();

        cout << dq.front().first<<' ';
    }

    return 0;
}
