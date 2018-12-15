//
// Created by ewa on 11/23/2018.
//
//
//x     CPP program to convert string to char array
//
//x     https://www.geeksforgeeks.org/convert-string-char-array-cpp/
//
#include <bits/stdc++.h>

using namespace std;

// driver code
int mainC2S()
{
// assigning value to string s
    string s = "geeksforgeeks";

    int n = s.length();

    cout << "\nstring is: " << s << "   len: " << n << endl<< endl;

    // declaring character array
    char char_array[n+1];

//x copying the contents of the string to char array
    strcpy(char_array, s.c_str());

    cout <<  endl;
    for (int i=0; i<n; i++)
        cout << char_array[i]<< " ";

    cout <<  endl;

//x     - OR -

    cout <<  "\n  - O R -" <<"\n\nby assingnig char by char to each string element...\n ";

    cout <<  endl;

//x     assigning value to  char  *p
    char p[]="geeks for geeks";
    string ss;

//x     copying
    for(int i=0;i<sizeof(p);i++)
    {
        ss[i]=p[i];
        cout << ss[i] << ",";
    }

    cout << "Final string: "  <<  ss  << endl;
    return 0;
}