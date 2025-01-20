#include <iostream>
#include <vector>
using namespace std;

class FindTheDuplicateNumber {
public:
    static int findDuplicate(const vector<int> &nums) {
        int slow = 0, fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow == slow2) {
                return slow;
            }
        }
    }
};

int main() {
    const int result = FindTheDuplicateNumber::findDuplicate(vector{1, 3, 4, 2, 2});
    cout << "Duplicate number: " << result << endl;

    const int result2 = FindTheDuplicateNumber::findDuplicate(vector{3, 1, 3, 4, 2});
    cout << "Duplicate number: " << result2 << endl;


    return 0;
}
