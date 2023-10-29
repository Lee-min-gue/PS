#include <iostream>
#include <string>
using namespace std;

int main() {
    string str, bomb;
    cin >> str >> bomb;

    string result = "";
    for(int i=0; i<str.size(); i++) {
        result += str[i];

        if(result.size() >= bomb.size() && result.substr(result.size() - bomb.size()) == bomb) {
            result.erase(result.size() - bomb.size());
        }
    }

    if(result.empty()) {
        cout << "FRULA" << endl;
    }
    else {
        cout << result << endl;
    }

    return 0;
}
