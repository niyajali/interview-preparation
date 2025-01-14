#include <iostream>
#include <vector>
using namespace std;

class MedianOfTwoSortedArrays {
public:
    static double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
        vector<int> &A = nums1;
        vector<int> &B = nums2;
        int total = A.size() + B.size();
        int half = (total + 1) / 2;

        if (B.size() < A.size()) {
            swap(A, B);
        }

        int left = 0;
        int right = A.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            int index = half - mid;

            int Aleft = mid > 0 ? A[mid - 1] : INT_MIN;
            int Aright = mid < A.size() ? A[mid] : INT_MAX;

            int Bleft = index > 0 ? B[index - 1] : INT_MIN;
            int Bright = index < B.size() ? B[index] : INT_MAX;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return max(Aleft, Bleft);
                } else {
                    return (max(Aleft, Bleft) + min(Aright, Bright)) / 2.0;
                }
            } else if (Aleft > Bright) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
};

int main() {
    vector<int> nums1 = {1, 3};
    vector<int> nums2 = {2};
    cout << MedianOfTwoSortedArrays::findMedianSortedArrays(nums1, nums2) << endl;

    vector<int> nums3 = {1, 2};
    vector<int> nums4 = {3, 4};
    cout << MedianOfTwoSortedArrays::findMedianSortedArrays(nums3, nums4) << endl;

    return 0;
}
