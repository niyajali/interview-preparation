#include <iostream>
#include <stack>
#include <vector>

using namespace std;

/**
* Daily Temperatures
Solved
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.

Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a
future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0
instead.

Example 1:

Input: temperatures = [30,38,30,36,35,40,28]

Output: [1,4,1,2,1,0,0]
Example 2:

Input: temperatures = [22,21,20]

Output: [0,0,0]
Constraints:

1 <= temperatures.length <= 1000.
1 <= temperatures[i] <= 100
 */
class DailyTemperatures {
public:
    static vector<int> dailyTemperatures(const vector<int> &temperatures) {
        vector<int> res(temperatures.size());
        stack<pair<int, int>> stack;

        for (int i = 0; i < temperatures.size(); i++) {
            int t = temperatures[i];
            while (!stack.empty() && t > stack.top().first) {
                auto pair = stack.top();
                stack.pop();
                res[pair.second] = i - pair.second;
            }

            stack.push({t, i});
        }

        return res;
    }
};


int main() {
    DailyTemperatures dt;
    const vector temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    vector<int> res = dt.dailyTemperatures(temperatures);
    for (const auto i: res) {
        cout << i << " ";
    }

    return 0;
}
