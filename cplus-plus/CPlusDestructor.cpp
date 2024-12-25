#include <iostream>
using namespace std;

static int count;

class Sample {
public:
    Sample() {
        cout << "Constructor Called " << count << endl;
        count++;
    }

    ~Sample() {
        cout << "Destructor Called " << count << endl;
        count--;
    }
};

class Test {
public:
    Test() {
        cout << "Test Constructor Called" << endl;
    }

private:
    ~Test() {
        cout << "Private Destructor Called" << endl;
    }
};

int main() {
    Sample s, s1, s2;
    auto t = (Test*)malloc(sizeof(Test));

    return 0;
}
