#include <iostream>
using namespace std;

struct Node {
    char left;
    char right;
} typedef Node;

Node tree[26];

void preorder(char node) {
    if(node == '.') return;
    cout << node;
    preorder(tree[node - 'A'].left);
    preorder(tree[node - 'A'].right);
}

void inorder(char node) {
    if(node == '.') return;
    inorder(tree[node - 'A'].left);
    cout << node;
    inorder(tree[node - 'A'].right);
}

void postorder(char node) {
    if(node == '.') return;
    postorder(tree[node - 'A'].left);
    postorder(tree[node - 'A'].right);
    cout << node;
}

int main() {
    int n;
    cin >> n;
    while(n--) {
        char node, left, right;
        cin >> node >> left >> right;
        tree[node - 'A'].left = left;
        tree[node - 'A'].right = right;
    }
    preorder('A'); cout << "\n";
    inorder('A'); cout << "\n";
    postorder('A'); cout << "\n";
    return 0;
}
