#include <iostream>
//
//x     https://www.geeksforgeeks.org/multiple-inheritance-in-c/
//
//
//  Show Initialization on
//  -   top level - class C only
//  -   all levels - classes: C, B, A
#include<iostream>


using namespace std;

class A
{
    string aa;
    int ii;

public:
  A(string in = "dft", int nn = -1)
  {
      string isStrArgDefl = in;
      if(in == "dft")
          isStrArgDefl = (" using a DFELT -> " + in);

      if(nn == -1)
        cout << "* A called with parms: string in: " <<   isStrArgDefl <<  " and  int  defaults to -1    "  << endl;
      else
        cout << "* A called with parms: string in: " <<   isStrArgDefl << " and  int is: " << nn << endl;
  }
};

class B
{
public:
  B()  { cout << "* B called with NO parm "<< endl; }
  B(string & in)  { cout << "* B called with parm: " << in << endl; }
};

class C: public B, public A  // Note the order
{
public:
  C(string &in)  { cout << "* C's constructor called with parm: " << in << endl; }

//Warn: initiating all constructor levels !!!
//  C(string &in, string wow, string aStr ) : B(wow),A(aStr) { cout << "** ** C's constructor called with parm: " << in << endl; }
  C(string &in, string &wow, string aStr ) : B(wow),A(aStr) { cout << "** ** C's constructor called with parm: " << in << endl; }
  C(string &in, string &wow, string aStr,  int aInt ) : B(wow),A(aStr, aInt) { cout << "** ** C's constructor called with parm: " << in << endl; }

};

//Warn:  TRICKY return by reference - requires EXTERNALLY provisioned REF to string .... otherwise would be the LOCAL SCOPE var to be returned
string & cnv(const char *x, string &ret){
    ret = x;    //copying the whole *x to string ret which is provided externallt
    return ret;
}
//Warn:  These cases:  should be returning string by value - so copy will be made  on RETURN .... otherwise ERROR occurs: no reference to LOCAL SCOPE


int main()
{
    string cS = "cccccccc  cc  cc", cSonly = "cccccccc  - only";
    string bS = "bbb", parentB = " >> Parent 'b' - is being initiated  ....";
    string aS = "aaaaaaaaaaaa";

    C cOnly(cSonly);

    cout << endl;
    C cbaa(cS, bS, aS,55);

    cout << endl;
    C cba(cS, parentB, " >> Parent 'a' - is being initiated  ....");

    cout << endl;


    auto xxx = const_cast<char*>("**** garbage - conv. (std::string &)(\"  bla  \") ******");
    string str(xxx);

    cout << endl;

//x  cnv to string requires  converting literal to const_cast<char*> and then condt char* to string - works but...

    C cba2(cS,  str, " >> Parent 'a' - is being initiated  ....");

    cout << endl;

//    cout << (std::string(const_cast<char*>("**** garbage - conv. (std::string &)(\"  bla  \") ******25"))) << "\n\n";


    string gotcha;  //Note:  needed to retrurn string reference (&gotcha) for literal

    C cba3(cS,  cnv("** Parent 'b' ->  is being initiated with: cnv(std::string &)(\"  bla  \") ******",gotcha),
            " >> Parent 'a'  ->  is being fully initiated - with literal and number  ", 9232);

    return 0;
}

/*
B's constructor called
A's constructor called
C's constructor called
 */