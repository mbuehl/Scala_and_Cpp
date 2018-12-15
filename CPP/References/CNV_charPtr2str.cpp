//
// Created by ewa on 11/23/2018.
//
//x     https://www.techiedelight.com/convert-char-array-string-cpp/
//
//x     char*  to  string

//
#include <iostream>

using namespace std;


int mainC2str()
{
    char  arr1[] = "Techie delight arr1  *";
    char  *arr2 =  "Techie delight arr2 *";

    cout << "\n1. String Constructor" << endl;

    string s(arr1);

    cout << "\nstring s(arr1);   = " << s << endl;

    cout << "\n\n1a. char arr1[] is: " << arr1 << "   len: " << (new string(arr1))->size() << ";  "<< *(new string(arr1))<< endl;
    cout << "\n1b. char *arr2  is: " << arr2 << "   len: " << (new string(arr2))->size() << ";  "<< *(new string(arr2))<< endl;
//--
    cout << "\n\n2. Assigment Operator" << endl;

    string sAsg = arr1;

    cout << "\nstring sAsg = arr1;   = " << sAsg << endl;



}


