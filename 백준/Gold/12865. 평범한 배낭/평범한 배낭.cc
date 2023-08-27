#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;



int main() {
	int N, K;
	cin >> N >> K;

	int w[100001];
	int v[100001];
	int dp[101][100001];

	for (int i = 1; i <= N; i++) {
		cin >> w[i] >> v[i];
	}
	for (int i = 1; i <=N; i++) {
		for (int j = 1; j <= K; j++) {
			if (j >= w[i]) {
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
			}
			else {
				dp[i][j] = dp[i - 1][j];
			}
		}
	}
	cout << dp[N][K];
	return 0;
}