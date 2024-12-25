#include <algorithm>
#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

/**
 * Duplicate Integer -
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * Example 1:
 * Input: nums = [1, 2, 3, 3]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: false
 */
class DuplicateInteger {
public:
    /**
     * Brute Force Approach
     * Step1: Loop through the array
     * Step2: Loop through the array again and check if the current element is equal to the next element
     * Step3: If it is equal, return true
     * Step4: If the loop ends, return false
     * TC - O(n^2) SC - O(1)
     * @param nums vector<int>
     * @return bool
     */
    static bool hasDuplicateBF(const vector<int> &nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    };

    /**
     * Sorting Approach
     * Step1: Sort the array
     * Step2: Loop through the array and check if the current element is equal to the next element
     * Step3: If it is equal, return true
     * Step4: If the loop ends, return false
     * TC - O(n log n) SC - O(1)
     * @param nums vector<int>
     * @return bool
     */
    static bool hasDuplicateSorting(vector<int> nums) {
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }

        return false;
    };

    /**
     * HashSet Approach
     * Step1: Create a hashset
     * Step2: Loop through the array and check if the current element is in the hashset
     * Step3: If it is in the hashset, return true
     * Step4: If the loop ends, return false
     * TC - O(n) SC - O(n)
     * @param nums vector<int>
     * @return bool
     */
    static bool hasDuplicateHashSet(const vector<int> &nums) {
        unordered_set<int> seen;

        for (int num: nums) {
            if (seen.count(num))
                return true;

            seen.insert(num);
        }

        return false;
    }

    /**
     * HashSet Length Approach
     * Step1: Create a hashset with the array
     * Step2: Check if the hashset size is less than the array size
     * TC - O(n) SC - O(n)
     * @param nums vector<int>
     * @return bool
     */
    static bool hasDuplicateHashSetLength(const vector<int> &nums) {
        return unordered_set(nums.begin(), nums.end()).size() < nums.size();
    }
};


int main() {
    cout << DuplicateInteger::hasDuplicateBF({1, 2, 3, 3}) << endl;
    cout << DuplicateInteger::hasDuplicateSorting({1, 2, 3, 4}) << endl;
    cout << DuplicateInteger::hasDuplicateHashSet({1, 2, 3, 3}) << endl;
    cout << DuplicateInteger::hasDuplicateHashSetLength({1, 2, 3, 4}) << endl;

    return 0;
}
