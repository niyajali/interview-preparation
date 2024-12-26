#include <iostream>
#include <vector>
using namespace std;

/**
* Q. Products of Array Except Self

    Given an integer array nums, return an array output where output[i] is the product
    of all the elements of nums except nums[i].

    Each product is guaranteed to fit in a 32-bit integer.

    Follow-up: Could you solve it in O(n) time without using the division operation?

    Example 1:

    Input: nums = [1,2,4,6]

    Output: [48,24,12,8]
    Example 2:

    Input: nums = [-1,0,1,2,3]

    Output: [0,-6,0,0,0]
 */
class ProductOfArray {
public:
    /**
     * Step1: Create vectors pref, suff and res of size n
     * Step2: Initialize pref[0] = 1 and suff[n - 1] = 1
     * Step3: Iterate from 1 to n - 1 and calculate pref[i] = nums[i - 1] * pref[i - 1]
     * Step4: Iterate from n - 2 to 0 and calculate suff[i] = nums[i + 1] * suff[i + 1]
     * Step5: Iterate from 0 to n - 1 and calculate res[i] = pref[i] * suff[i]
     * Step6: Return res vector
     * @param nums vector<int>
     * @return vector<int>
     */
    static vector<int> productExceptSelfPS(const vector<int> &nums) {
        const int n = nums.size();
        vector<int> pref(n), suff(n), res(n);

        pref[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }


    static vector<int> productExceptSelfPSOptimized(const vector<int> &nums) {
        const int n = nums.size();
        vector<int> res(n, 1);

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

};

/**
 * input = [1,2,3, 4]
 *
 * prefix = [1,1,2,6]
 *
 * postfix = [24,12,4,1]
 *
 *
 *
 * res[3] = 6 * 1 = 6 | right = 4 * 1 = 4
 * res[2] = 2 * 4 = 8 | right = 3 * 4 = 12
 * res[1] = 1 * 12 = 12 | right = 2 * 12 = 24
 * res[0] = 1 * 24 = 24 | right = 1 * 24 = 24
 *
 * output = [24, 12, 8, 6]
 *
 */
int main() {
    const vector<int> nums = {1, 2, 3, 4};
    vector<int> output = ProductOfArray::productExceptSelfPSOptimized(nums);
    for (const auto o: output) {
        cout << o << ",";
    }

    return 0;
}
