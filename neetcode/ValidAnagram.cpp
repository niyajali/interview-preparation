#include <algorithm>
#include<iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

/**
* Valid Anagram -
* Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
* An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
*
* Example 1:
* Input: s = "racecar", t = "carrace"
* Output: true
*
* Example 2:
* Input: s = "jar", t = "jam"
* Output: false
*
* Constraints:
* s and t consist of lowercase English letters.
 */

class ValidAnagram {
public:
    static bool checkIsAnagramSorting(string firstInput, string secondInput) {
        if (firstInput.length() != secondInput.length()) {
            return false;
        }

        sort(firstInput.begin(), firstInput.end());
        sort(secondInput.begin(), secondInput.end());

        return firstInput == secondInput;
    }

    static bool checkIsAnagramHashTable(const string &s, const string &t) {
        if (s.length() < t.length()) {
            return false;
        }

        unordered_map<char, int> countS;
        unordered_map<char, int> countT;

        for (int i = 0; i < s.length(); i++) {
            countS[s[i]]++;
            countT[t[i]]++;
        }

        return countS == countT;
    }

    static bool checkIsAnagramHashTableOptimal(const string &s, const string &t) {
        // First check: if lengths are different, they can't be anagrams
        if (s.length() < t.length()) {
            return false;
        }

        // Create an array to store character counts
        // Size 26 because we're assuming lowercase English letters only
        vector count(26, 0);

        // Process both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            count[s[i] - 'a']++; // Increment count for char in s
            count[t[i] - 'a']--; // Decrement count for char in t
        }

        // Check if all counts are zero
        for (const int value: count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
};

int main() {
    cout << ValidAnagram::checkIsAnagramSorting("racecar", "carrace") << endl;
    cout << ValidAnagram::checkIsAnagramHashTable("tea", "eat") << endl;
    cout << ValidAnagram::checkIsAnagramHashTableOptimal("cat", "ca") << endl;

    return 0;
}
