//
// Created by niyaj on 11/16/2024.
//

#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class GroupAnagrams {
public:
    /**
     * Group Anagrams using sorting
     *
     * - Step1: create temp map variable to save sorted string with key.
     * - Step2: iterate through list of string and sort element
     * - Step3: create temp variable to save current element
     * - Step4: sort current element and save the key and string to map
     * - Step5: return the values of map
     *
     * @param strs vector<string>
     * @return vector<vector<string>>
     */
    static vector<vector<string> > groupAnagramsSorting(vector<string> strs) {
        unordered_map<string, vector<string> > res;

        for (auto &str: strs) {
            string sortedS = str;

            sort(sortedS.begin(), sortedS.end());
            res[sortedS].push_back(str);
        }

        vector<vector<string> > result;
        result.reserve(res.size());
        for (auto &[fst, snd]: res) {
            result.push_back(snd);
        }

        return result;
    }

    /**
     * Group Anagrams using HashMap
     *
     * Step1: Create a temp Map to store key -> group of anagrams
     * Step2: Iterate through the list
     * Step3: Count frequency of each character
     * Step4: Create key from character counts
     * Step5: Add string to its anagram group
     * Step5: Convert map values to result vector
     * Step6: Return the result
     *
     * @param strs vector<string>
     * @return vector<vector<string>>
     */
    static vector<vector<string> > groupAnagramsHashMap(vector<string> strs) {
        unordered_map<string, vector<string> > res;

        for (const auto &str: strs) {
            vector<int> count(26, 0);

            for (const char c: str) {
                count[c - 'a']++;
            }

            string key = to_string(count[0]);
            for (int i = 1; i < 26; i++) {
                key += "," + to_string(count[i]);
            }

            res[key].push_back(str);
        }

        vector<vector<string> > result;
        result.reserve(res.size());
        for (auto &[fst, snd]: res) {
            result.push_back(snd);
        }

        return result;
    }
};

int main() {
    cout << "Group Anagrams using Sorting" << endl;

    vector<vector<string> > result = GroupAnagrams::groupAnagramsSorting(
        {"eat", "tea", "tan", "ate", "nat", "bat"}
    );
    for (auto &r: result) {
        for (auto &s: r) {
            cout << s << " ";
        }
        cout << endl;
    }

    cout << endl;
    cout << "Group Anagrams using HashMap" << endl;

    vector<vector<string> > resultHM = GroupAnagrams::groupAnagramsHashMap(
        {"act", "pots", "tops", "cat", "stop", "hat"}
    );
    for (auto &r: resultHM) {
        for (auto &s: r) {
            cout << s << " ";
        }
        cout << endl;
    }
}
