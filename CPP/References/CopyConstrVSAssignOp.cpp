//
// Created by ewa on 11/17/2018.
//

#include<iostream>
#include<stdio.h>

using namespace std;

// const is like final in java

class Test
{
public:
    Test() {}

    Test(const Test &t)    {
        cout<<"Copy constructor called "<<endl;
    }

    Test& operator = (const Test &t)    {
        cout<<"Assignment operator called "<<endl;
    }
};

int mainXX()
{
    Test t1, t2;
    t2 = t1;                // copy

    Test t3 = t1;           // assignment
    getchar();

    return 0;
}
