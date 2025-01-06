#include <iostream>
#include <stack>
#include <vector>
using namespace std;

class EveluateReversePolishNotation {
public:
    static int evalRPN(vector<string> &tokens) {
        stack<int> stack;

        for (const string &token: tokens) {
            if (token == "+") {
                const int a = stack.top();
                stack.pop();
                const int b = stack.top();
                stack.pop();

                stack.push(a + b);
            } else if (token == "-") {
                const int a = stack.top();
                stack.pop();
                const int b = stack.top();
                stack.pop();

                stack.push(b - a);
            } else if (token == "*") {
                const int a = stack.top();
                stack.pop();
                const int b = stack.top();
                stack.pop();

                stack.push(a * b);
            } else if (token == "/") {
                const int a = stack.top();
                stack.pop();
                const int b = stack.top();
                stack.pop();

                stack.push(b / a);
            } else {
                stack.push(stoi(token));
            }
        }

        return stack.top();
    }
};

int main() {
    vector<string> tokens = {"2", "1", "+", "3", "*"};
    cout << EveluateReversePolishNotation::evalRPN(tokens) << endl;
    return 0;
}
