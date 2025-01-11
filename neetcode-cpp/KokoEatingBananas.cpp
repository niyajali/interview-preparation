#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

class KokoEatingBananas {
public:
    static int minEatingSpeed(vector<int> &piles, int h) {
        int left = 1;
        int right = *max_element(piles.begin(), piles.end());
        int res = right;

        while (left <= right) {
            const int mid = left + ((right - left) / 2);
            long long totalTime = 0;

            for (const int i: piles) {
                totalTime += ceil(static_cast<double>(i) / mid);
            }

            if (totalTime <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
};

int main() {
    vector<int> piles = {3, 6, 7, 11};
    int h = 8;
    cout << KokoEatingBananas::minEatingSpeed(piles, h) << endl;

    vector<int> piles2 = {30, 11, 23, 4, 20};
    int h2 = 5;
    cout << KokoEatingBananas::minEatingSpeed(piles2, h2) << endl;


    return 0;
}
