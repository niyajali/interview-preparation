#include <iostream>
#include <vector>
using namespace std;

class FindMinimumInRotatedSortedArray {
public:
    static int findMin(const vector<int> &nums) {
        int left = 0;
        int right = nums.size() - 1;
        int res = nums[0];

        while (left <= right) {
            if (nums[left] <= nums[right]) {
                res = min(res, nums[left]);
                break;
            }

            const int mid = left + ((right - left) / 2);
            res = min(res, nums[mid]);


            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
};

int main() {
    vector<int> nums = {3, 4, 5, 1, 2};
    cout << FindMinimumInRotatedSortedArray::findMin(nums) << endl;

    vector<int> nums2 = {4, 5, 6, 7, 0, 1, 2};
    cout << FindMinimumInRotatedSortedArray::findMin(nums2) << endl;

    return 0;
}
