#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class TwoSum {
public:
    static vector<int> findSumBruteForce(const vector<int> &arr, const int sum) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr[i] + arr[j] == sum) {
                    return {i, j};
                }
            }
        }

        return {};
    };

    static vector<int> findSumHashMap(const vector<int> &arr, const int sum) {
        unordered_map<int, int> prevNum;

        for (int i = 0; i < arr.size(); i++) {
            const int diff = sum - arr[i];

            if (prevNum.find(diff) != prevNum.end()) {
                return {prevNum[diff], i};
            }

            prevNum.insert({arr[i], i});
        }

        return {};
    };
};

int main() {
    const vector<int> resultBF = TwoSum::findSumBruteForce({2, 7, 1, 3}, 4);
    const vector<int> resultHM = TwoSum::findSumHashMap({3,4,5,6}, 7);

    cout << resultBF[0] << " " << resultBF[1] << endl;
    cout << resultHM[0] << " " << resultHM[1] << endl;
}
