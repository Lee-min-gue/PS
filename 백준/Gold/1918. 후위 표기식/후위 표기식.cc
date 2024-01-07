#include <iostream>
#include "stack"
#include "string"

using namespace std;

int precedence(char ch){
    if(ch=='+' || ch=='-')return 1;
    else if(ch=='*' || ch=='/')return 2;
    else if(ch=='^')return 3;
    else return -1;
}

string InfixToPostFix(string expression){

    string result = "";
    stack<char> stack;

    for(int i=0; i<expression.length(); i++){
        char c = expression.at(i);

        if(isalnum(c))
            result.append(1, c);

        else if(c == '(')
            stack.push(c);

        else if(c == ')'){
            while (!stack.empty() && stack.top() != '(')
                result.append(1, stack.top()), stack.pop();

            if(!stack.empty() && stack.top() != '(')
                return "ERROR";
            else
                stack.pop();
        }

        else{
            while (!stack.empty() && precedence(c) <= precedence(stack.top()))
                result.append(1, stack.top()), stack.pop();
            stack.push(c);
        }
    }

    while (!stack.empty())
        result.append(1, stack.top()), stack.pop();

    return result;
}


int main() {
    string st;
    getline(cin, st);
    cout<< InfixToPostFix(st) <<endl;
    return 0;
}
