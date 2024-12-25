#include "iostream"
using namespace std;

class Student {
    string name;
    int rollNo;
    int age;

public:
    Student(const string &name, const int rollNo, const int age) {
        this->name = name;
        this->rollNo = rollNo;
        this->age = age;
    };

    Student(const Student &s) {
        name = s.name;
        rollNo = s.rollNo;
        age = s.age;
        cout << "Copy Constructor Called" << endl;
    }

    void display() const;
};

void Student::display() const {
    cout << "Name: " << name << endl;
    cout << "Roll No: " << rollNo << endl;
    cout << "Age: " << age << endl;
}

int main() {
    const Student s("Niyaj", 2, 24);
    s.display();

    const Student s1(s);
    s1.display();

    return 0;
}
