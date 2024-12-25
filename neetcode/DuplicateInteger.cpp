

#include <iostream>
#include <algorithm>
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
namespace neetcode {
    class DuplicateInteger {
    public:
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

        static bool hasDuplicateSorting(const vector<int> &nums) {
            std::sort(nums.begin(), nums.end());

            for (int i = 1; i < nums.size(); i++) {
                if (nums[i] == nums[i - 1]) return true;
            }

            return false;
        };

        static bool hasDuplicateHashSet(const vector<int> &nums) {
            unordered_set<int> seen;

            for (int num: nums) {
                if (seen.count(num)) return true;

                seen.insert(num);
            }

            return false;
        }

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
}