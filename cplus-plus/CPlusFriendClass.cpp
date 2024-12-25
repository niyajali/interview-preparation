#include <iostream>
using namespace std;

class Sample;

class AnotherClass {
public:
    static void display(const Sample &s);
};

class Sample {
private:
    int privateNum;

protected:
    int protectedNum;

public:
    Sample() {
        privateNum = 10;
        protectedNum = 20;
    }

    Sample(const int p, const int pr) {
        privateNum = p;
        protectedNum = pr;
    }

    friend class FriendSimple;

    friend void friendFunction(Sample sample);

    friend void AnotherClass::display(const Sample &s);
};

class FriendSimple {
public:
    static void display(const Sample s) {
        cout << "Private Number: " << s.privateNum << endl;
        cout << "Protected Number: " << s.protectedNum << endl;
        cout << endl;
    }
};

void friendFunction(const Sample sample) {
    cout << "Private Number: " << sample.privateNum << endl;
    cout << "Protected Number: " << sample.protectedNum << endl;
    cout << endl;
}

void AnotherClass::display(const Sample &s) {
    cout << "Private Number: " << s.privateNum << endl;
    cout << "Protected Number: " << s.protectedNum << endl;
    cout << endl;
}

int main() {
    const auto s = Sample(30, 40);
    FriendSimple::display(s);
    friendFunction(s);
    AnotherClass::display(s);

    return 0;
}
