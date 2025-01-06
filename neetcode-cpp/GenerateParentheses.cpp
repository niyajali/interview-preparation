#include<iostream>
#include<vector>
using namespace std;

class GenerateParentheses {
public:
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * @param openN int
     * @param closeN int
     * @param n int
     * @param res vector<string>
     * @param stack string
     */
    void backtrack(const int openN, const int closeN, int n, vector<string>& res, string stack){
        if(openN == n && closeN == n){
            res.push_back(stack);
            return;
        }

        if(openN < n){
            stack += '(';
            backtrack(openN+1, closeN, n, res, stack);
            stack.pop_back();
        }

        if(closeN < openN){
            stack += ')';
            backtrack(openN, closeN+1, n, res, stack);
            stack.pop_back();
        }
    }


    vector<string> generateParenthesis(int n) {
        vector<string>res;
        string stack;

        backtrack(0,0,n,res,stack);
        return res;
    }
};


int main() {
    GenerateParentheses gp;
    vector<string> res = gp.generateParenthesis(3);
    for(auto s: res){
        cout<<s<<endl;
    }


    return 0;
}