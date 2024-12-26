#include <iostream>
#include <vector>
using namespace std;

/**
* Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
 */
class EncodeAndDecodeString {
public:
    /**
     * Encode list of String
     * Step1: Iterate through the list of strings
     * Step2: Append the length of the string and the string itself with '#' as separator
     * Step3: Return the encoded string
     * For example: ["neet","code","love","you"] => "4#neet4#code4#love3#you"
     * @param strs vector<string>
     * @return string
     */
    static string encode(vector<string> &strs) {
        string encodedStr;
        for (const auto &str: strs) {
            encodedStr += to_string(str.length()) + "#" + str;
        }

        return encodedStr;
    }

    /**
     * Decode the encoded string
     * Step1: Iterate through the encoded string
     * Step2: Find the first occurrence of '#' to get the length of the string
     * Step3: Get the substring from the next character to the length of the string
     * Step4: Add the substring to the vector of strings
     * Step5: Move the pointer to the next character after the length of the string
     * Step6: Return the vector of strings
     * @param s string
     * @return vector<string>
     */
    static vector<string> decode(const string &s) {
        vector<string> decodedStrs;
        int i = 0;
        while (i < s.length()) {
            const int pos = s.find('#', i);
            const int len = stoi(s.substr(i, pos - i));
            decodedStrs.push_back(s.substr(pos + 1, len));
            i = pos + len + 1;
        }

        return decodedStrs;
    }
};

int main() {
    vector<string> strs = {"neet", "code", "love", "you"};

    const string encodedStr = EncodeAndDecodeString::encode(strs);
    cout << "Encoded String: " << encodedStr << endl;

    vector<string> decodedStrs = EncodeAndDecodeString::decode(encodedStr);
    cout << "Decoded Strings: ";
    for (const auto &str: decodedStrs) {
        cout << str << " ";
    }

    return 0;
}
