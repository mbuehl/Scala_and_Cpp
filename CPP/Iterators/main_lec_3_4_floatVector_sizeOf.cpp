#include <iostream>
#include "stdlib.h"
#include <cassert> // assert.h in C    Error is displayed, with line number of failure.

#include "utl.h"

#include <vector>
#include <iterator>
/*x                                                                                                                 -
 *x   FloatVect jest pojedyncza struktura, ktora w srodku ma private data:                                          -
 *x                                                                                                                 -
 *x   - array of  float                                                                                             -
 *x   - int size                                                                                                    -
 *
 *x   ...'name' is just for naming the structure                                                                    -
 *x                                                                                                                 -
 */


using namespace std;

/*
 x When a class dynamically allocates memory:

 x    Do the allocation in the constructor(s)
 x    Release memory in the destructor

x  Example: Vector of float values
*/

template<typename T, size_t N>
size_t arraySize( T(&)[N] )
{
    return(N);
}

class FloatVct
{
    int numElems;           // Size of the vector
    float *elems;           // Dynamically allocated array of vector's elements
    string name;
public:
    FloatVct() {FloatVct(100);}
    FloatVct(int n, const char *name = " default_name_");
    ~FloatVct();
    FloatVct(FloatVct const &); //copy constructor =>  deep copy
//
//Note:   adding iteration capability
//
    typedef FloatVct* iterator;
    iterator begin() {return this;}
    iterator end() {return &this[numElems];}


//x operators
    FloatVct const& operator= (FloatVct &fv);

//    void prt(FloatVct &, char *narr = 0);    //  Prints
    void prt(int , char * ) const ;

    FloatVct& set(int, float);

    float get(int i) const    {
        return elems[i];
    }
    int getSz()  const    {
        return numElems;
    }
};

//===========================================================

FloatVct::FloatVct(int n, const char *nm)
{                                                                       //x     Constructor
    cout << "\n\n+++++++++  Constructor has been called... for name = " << nm  << endl;
//    char xx[20];
//    sprintf(xx, "%2d",rand() % 100);
    name = nm;

    numElems = n;
    elems = new float[numElems];
    for (int i = 0; i < numElems; i++)
        elems[i] = 0;
}
//
//Warn (Default Copy-Constructor) This is a shallow copy ..
//Warn If the data-member is a pointer, only the pointer is duplicated!
//
FloatVct::FloatVct(FloatVct const &fv )  {                  //x     Copy-Constructor  - deep copy
    name += fv.name + "*CC";

    cout << "\n\n******   Copy constructor has been called...for  name = " << name << endl;
    numElems = fv.numElems;
//warn:  DON'T just copy the pointer value
    elems = new float[numElems];            // Allocate space
    for (int i = 0; i < numElems; i++)
        elems[i] = fv.elems[i];             // Copy the data over
}


FloatVct const & FloatVct:: operator= (FloatVct &fv)
{                                                                    //x     Assignemnt '='  - deep copy
    name += fv.name + "*Asgn";

    cout << "\n\n******  assingment operator = has been called...for name = " << fv.name << endl;
    numElems = fv.numElems;
//warn:  DON'T just copy the pointer value
    elems = new float[numElems];            // Allocate space
    for (int i = 0; i < numElems; i++)
        elems[i] = fv.elems[i];             // Copy the data over
}



// Clean up the float-vector.
FloatVct::~FloatVct() {                                       //x     Destructor
    cout << "\n\n*****     Destructor has been called.. for name = "  << this->name  <<endl;

    delete[] elems; // Release the memory for the array.
}

void prt(FloatVct &p, const char *narr) {                 //x     Print
    cout << narr << " ";
    for (int i = 0; i < p.getSz(); i++)
        cout << p.get(i)  << ", ";

    cout << endl;
}

void FloatVct::prt(int ii, char *narr) const{                 //x     Print
    cout << narr << " - " << elems[ii] << "\n ";
}

FloatVct& FloatVct::set(int elNo, float val)           //x     Returning *this in Setter calls for Copy Constructor
{
    if(elNo >= numElems-1)
        assert(elNo);

    elems[elNo] = val;

    return *this;
}


void loopThruPt(FloatVct &vec, const char* lbl = "")
{
    cout <<  "\n*\n" <<lbl << "  !!! loopThruPt !!!" << endl;

    string str ;
    for(int i =0; i< vec.getSz();i++)
    {
        char cnv[20];
        vec.get(i) != 0.00?
            sprintf(cnv,"%2d =>> %4.1f.  ",i,vec.get(i)):
            sprintf(cnv,"%2d    ",i);

        str += cnv;
//        str +=  "th****after: ";
//        vec->prt(vec->get(i), (char *) str.c_str());
    }
    cout << (char *) str.c_str()  << "...";
    cout << endl;
}

//x ----------------------------------------------------------
int main()
{
    cout << "\nobjects    new/delete\n-----------------------\n";

    FloatVct *fv = new FloatVct(35, "*fv");     // allocating
    for(int i=0;i < fv->getSz();i++)
        fv->set(i, i*2.1);

//1-st block
    {
        cout << "Ex:  fv is a pointer to FloatVct instance\n";


        FloatVct ref1 = *fv;



//        auto sz = end(FloatVct &fv)-begin(FloatVct (&)fv);

        cout << "\n\nLength of array = " << fv->getSz() << endl;
        prt(*fv,s2c("*fv"));


        cout << "\n\nLength of array = " << ref1.getSz() << endl;
        prt(ref1, s2c("ref1 = *fv"));

        for(int i=0;i < fv->getSz();i++)
            fv->set(i, i*4.0);

        prt(*fv,"*fv after doubling values  is.... ");

        cout << "\n\nLength of array = " << ref1.getSz() << endl;
        prt(ref1,"ref1 != *fv  should be");

    }

//x
    {
        FloatVct fvect(100,"**fvect(100)**"); // Use our vector

        string arS[55];
        arS[0] = "knknkknnknkknk";  arS[12] = "12___   x  ";
        arS[27] = "272727272727knk";
        arS[44] = "k777777knk";

        auto sz = end(arS)-begin(arS);

        cout << "\n\nLength of array = " << sz << endl;
        int i=0;
        for(string x: arS)
        {
            i++;
            if (x.length() > 0)
                cout << i << ".  " << x << endl;
        }


        assert(sz == 55);//warn:   If condition is false, the program will halt.

    }   // <--- fvect’s destructor automatically called here.

//x     ITERATOR thru the internal array of *elems
    {
        int sz = fv->end() - fv->begin();
        cout << "it size: " <<  (fv->end() - fv->begin()) << endl;

        int i = 0;
        for(auto x = fv->begin() ; i < sz; i++)
            cout << "it: " << i << "  -> " << x->get(i) << endl;


    }

//x     ITERATOR thru then



    cout << "\n\ndone..." << endl;

    return 0;
}





/*
 *
 */