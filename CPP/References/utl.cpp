//
// Created by ewa on 11/23/2018.
//
//x     https://bytes.com/topic/c/answers/544209-std-string-c_str-const_cast-char
//
//
//


#include <iostream>

using namespace std;


const char* s2c(const string &s)
{
    return s.c_str();
//    return   const_cast<char *>(s);
}

