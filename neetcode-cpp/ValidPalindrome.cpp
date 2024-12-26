#include <iostream>
using namespace std;

/**
* Given a string s, return true if it is a palindrome, otherwise return false.
*
* A palindrome is a string that reads the same forward and backward.
* It is also case-insensitive and ignores all non-alphanumeric characters.
*
*  Example 1:
*
*  Input: s = "Was it a car or a cat I saw?"
*
*  Output: true
*  Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
*
*  Example 2:
*
*  Input: s = "tab a cat"
*
*  Output: false
*  Explanation: "tabacat" is not a palindrome.
*
*  Constraints:
*
*  1 <= s.length <= 1000
*  s is made up of only printable ASCII characters.
*
 */
class ValidPalindrome {
public:
    /**
     * Check if a string is a palindrome or not, using sorting
     * @param str string
     * @return boolean
     *
     * Step1: Create a new string with only alphanumeric characters in lowercase
     * Step2: Compare with reverse of the string
     */
    static bool isPalindromeSorting(const string &str) {
        string reverseStr;
        for (const char c: str) {
            if (isalnum(c)) {
                reverseStr += tolower(c);
            }
        }

        return reverseStr == string(reverseStr.rbegin(), reverseStr.rend());
    }

    /**
     * Check if a string is a palindrome or not, using two pointers
     * Step1: Use two pointers, one from start and one from end
     * Step2: Compare the characters at both pointers
     * Step3: If both characters are not alphanumeric, move the pointers
     * Step4: If both characters are not equal, return false
     * @param str string
     * @return boolean
     */
    static bool isPalindromeTwoPointer(const string &str) {
        int left = 0;
        int right = str.size() - 1;

        while (left < right) {
            if (!isalnum(str[left])) {
                left++;
            } else if (!isalnum(str[right])) {
                right--;
            } else if (tolower(str[left]) == tolower(str[right])) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    static bool isPalindrome(const string &str) {
        string cleaned;
        for (const char i: str) {
            if (iswalnum(i)) {
                cleaned += tolower(i);
            }
        }

        for (int j = 0; j < cleaned.size() / 2; j++) {
            if (cleaned[j] != cleaned[cleaned.size() - j - 1]) {
                return false;
            }
        }

        return true;
    }
};

int main() {
    cout << ValidPalindrome::isPalindromeSorting("Was it a car or a cat I saw?") << endl;
    cout << ValidPalindrome::isPalindromeTwoPointer("tab a cat") << endl;

    return 0;
}
