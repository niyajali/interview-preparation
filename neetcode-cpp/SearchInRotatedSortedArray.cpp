#include <iostream>
#include <vector>
using namespace std;

class SearchInRotatedSortedArray {
public:
    static int search(const vector<int> &nums, const int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            const int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
};

int main() {
    vector<int> nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 0;
    cout << SearchInRotatedSortedArray::search(nums, target) << endl;

    vector<int> nums2 = {4, 5, 6, 7, 0, 1, 2};
    int target2 = 3;
    cout << SearchInRotatedSortedArray::search(nums2, target2) << endl;

    return 0;
}
