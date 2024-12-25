#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

/**
 * Top K Frequent Elements

    Given an integer array nums and an integer k, return the k most frequent elements within the array.

    The test cases are generated such that the answer is always unique.

    You may return the output in any order.

    Example 1:

    Input: nums = [1,2,2,3,3,3], k = 2

    Output: [2,3]

    Example 2:

    Input: nums = [7,7], k = 1

    Output: [7]

    Constraints:

    - 1 <= nums.length <= 10^4.
    - 1000 <= nums[i] <= 1000
    - 1 <= k <= number of distinct elements in nums.
 */
class TopKFrequentElement {
    /**
     * Step1: Create a map of frequency of each element
     * Step2: Iterate over the number and count frequency of numbers
     * Step3: Iterate over the map and create a vector of pairs
     * Step4: Sort the vector of pairs based on the frequency
     * Step5: Return the top k elements
     * @param nums vector<int>
     * @param k int
     * @return vector<int>
     */
    static vector<int> topKFrequentSorting(vector<int> &nums, const int k) {
        unordered_map<int, int> count;

        for (const auto &num: nums) {
            count[num]++;
        }

        vector<pair<int, int>> freq;
        freq.reserve(count.size());

        for (const auto &[fst, snd]: count) {
            freq.emplace_back(fst, snd);
        }

        sort(freq.rbegin(), freq.rend());

        vector<int> res;
        res.reserve(k);
        for (int i = 0; i < k; i++) {
            res.push_back(freq[i].second);
        }

        return res;
    }
};

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}
