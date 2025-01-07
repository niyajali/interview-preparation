#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

class CarFleet {
public:
    static int carFleet(const int target, vector<int> &position, vector<int> &speed) {
        vector<pair<int, int>> pairs;
        pairs.reserve(position.size());
        for (int i = 0; i < position.size(); i++) {
            pairs.emplace_back(position[i], speed[i]);
        }

        sort(pairs.rbegin(), pairs.rend());
        vector<double> stack;

        for (auto &[pos, spd]: pairs) {
            double time = static_cast<double>(target - pos) / spd;
            stack.push_back(time);


            if (stack.size() >= 2 && stack.back() <= stack[stack.size() - 2]) {
                stack.pop_back();
            }
        }

        return stack.size();
    }
};

int main() {

    vector<int> position = {10, 8, 0, 5, 3};
    vector<int> speed = {2, 4, 1, 1, 3};
    int target = 12;
    cout << CarFleet::carFleet(target, position, speed) << endl;

    return 0;
}
