#include <iostream>
#include <map>
#include <unordered_map>
using namespace std;

class TimeBasedKeyValueStore {
public:
    unordered_map<string, map<int, string>> m;

    TimeBasedKeyValueStore() {}

    void set(string key, string value, int timestamp) {
        m[key].insert({timestamp, value});
    }

    string get(string key, int timestamp) {
        auto it = m[key].upper_bound(timestamp);
        return it == m[key].begin() ? "" : prev(it)->second;
    }
};

int main() {
    TimeBasedKeyValueStore obj;
    obj.set("foo", "bar", 1);
    cout << obj.get("foo", 1) << endl;
    cout << obj.get("foo", 3) << endl;
    obj.set("foo", "bar2", 4);
    cout << obj.get("foo", 4) << endl;
    cout << obj.get("foo", 5) << endl;

    return 0;
}
