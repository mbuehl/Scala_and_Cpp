//
// Created by ewa on 11/22/2018.
//
//x      for_each:    template <class InputIterator, class Function>
//x                      Function for_each (InputIterator first, InputIterator last, Function fn);
//x      copy:
//x

//x https://stackoverflow.com/questions/7082261/how-do-i-add-foreach-iteration-support-to-my-own-collection-class-in-c

#include <algorithm>
#include <iostream>
#include <iterator>
#include <vector>       // std::vector

using namespace std;

// very very simple container class
class Cont
{
    public:
        Cont() {}
        typedef char* iterator;
        iterator begin() {return arr;}
        iterator end() {return &arr[200];}

    private:
        char arr[200];
};

void setit(char &it) {
    it = 'a';
}


//x  About 'for_each' from http://www.cplusplus.com/reference/algorithm/for_each/

void myfunction (int i) {  //x      function:
    std::cout << ' ' << i;
}


struct myclass              //x     function object type:
{
    int z = 3;
    void operator() (int i)
    {
        std::cout << ' ' << i+ (z+=5);
    }
} myobject;





//Note: iterator must provide ++ operation for for_each algorithm (char* in this example works this way)

int mainITER()
{
//x-----------------------------------------------------------------------------------------
//x  From:  https://stackoverflow.com/questions/7082261/how-do-i-add-foreach-iteration-support-to-my-own-collection-class-in-c
    Cont c;

    for_each(c.begin(), c.end(), setit);

    copy(c.begin(), c.end(), ostream_iterator<int>( std::cout, ","));

    auto sz = c.end() - c.begin();

    cout << "Cont 'c' size seem to be: " << sz << endl;


//x-----------------------------------------------------------------------------------------
//x  - AND -  for  'for_each' from http://www.cplusplus.com/reference/algorithm/for_each/

    cout << "\n\n\n";

    vector<int> myVct;
    myVct.push_back(10);
    myVct.push_back(20);
    myVct.push_back(30);

//x .... function:
    cout << "myVct contains [ for_each (myVct.begin(), myVct.end(), myfunction) ]:";
    for_each (myVct.begin(), myVct.end(), myfunction);
    cout << '\n';

    cout << "myVct 'myvect' size seem to be: " << (myVct.end()-myVct.begin()) << endl;

//x .... or  object:

    cout << "myVct contains[ for_each (myVct.begin(), myVct.end(), myobject)]:";
    for_each (myVct.begin(), myVct.end(), myobject);
    cout << '\n';
//


    return 0;
}

