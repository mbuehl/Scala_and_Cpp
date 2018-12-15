#include <iostream>
#include <ostream>

//x         Goal:       convert literal to string &

using namespace std;

class B
{
public:
    B()  { cout << "* B called with NO parm "<< endl; }
    B(string & in)  { cout << "* B called with parm: " << in << endl; }
};

class C: public B  // Note the order
{
public:
    C(string &in)  { cout << "* C's constructor called with parm: " << in << endl; }


    C(string &in, string wow) : B(wow) { cout << "** ** C's constructor called with parm: '" << in << "'" << endl; }
};



//Warn:  return by reference - requires EXTERNALLY provisioned REF to string .... otherwise would be the LOCAL SCOPE
string & cnv(const char *x, string &ret){
    ret = x;    //copying the whole *x to string ret which is provided externallt
    return ret;
}
//Warn:  These cases:  should be returning string by value - so copy will be made  on RETURN .... otherwise ERROR occurs: no reference to LOCAL SCOPE


//---------------------------------------------------------------------------------------------------------------------
int main()
{
    string cS = "cccccccc  cc  cc", cSonly = "cccccccc  - only";
    string bS = "bbb", parentB = " >> Parent 'b' - is being initiated  ....";
    string aS = "aaaaaaaaaaaa";

    std::cout << "Convert literal to string ref &  ...." << std::endl;

//x--
    std::cout << "1234567890" << "\b\b\b\b\b\b" <<  "abcdefg" << endl;

              //This will work
    auto xxx = const_cast<char*>("**** garbage - conv. (std::string &)(\"  bla  \") ******");
    string str(xxx);

    cout << endl;

//x  cnv to string requires  cinverting literal to const_cast<char*> and then condt char* to string - works but...
    C cba2(cS,  xxx);

    cout << endl;

    cout << (std::string(const_cast<char*>("**** garbage - conv. (std::string &)(\"  bla  \") ******25"))) << "\n\n";


//todo 12/4/18  auto xxx and str(xxx) on the fly -- that might be OK
    string gotcha;
    C cba3(  cnv(const_cast<char*>( "987 **** conv. (std::string & **789" ),gotcha), cS);





    return 0;
}