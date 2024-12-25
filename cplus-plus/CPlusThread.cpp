#include <functional>
#include <iostream>
#include <mutex>
#include <thread>
using namespace std;

thread_local int value = 10;
mutex mtx;

int main() {

    thread t1([] {
        value += 18;
        lock_guard<mutex> lock(mtx);
        cout << "Thread 1: " << value << endl;
    });

    thread t2([] {
        value += 20;
        lock_guard<mutex> lock(mtx);
        cout << "Thread 2: " << value << endl;
    });

    thread t3([] {
        value += 22;
        lock_guard<mutex> lock(mtx);
        cout << "Thread 3: " << value << endl;
    });

    t1.join();
    t2.join();
    t3.join();

    cout << "Main: " << value << endl;

    return 0;
}
