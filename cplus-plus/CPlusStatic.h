//
// Created by niyaj on 11/10/2024.
//
#pragma once

#include "iostream"
#ifndef STATIC_H
#define STATIC_H
using namespace std;

inline void demo() {
    static int count = 0;

    cout << "Count: " << count << endl;

    count ++;
}

inline int StaticVariableInAFunction() {
    for (int i = 0; i < 5; i++) {
        demo();
    }

    return 0;
}


class CPlusStatic {

};



#endif //STATIC_H
