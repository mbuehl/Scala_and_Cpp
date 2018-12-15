#include <iostream>
#include "stdlib.h"
#include <cassert> // assert.h in C    Error is displayed, with line number of failure.


#include <vector>
#include <iterator>
/*
 x  POINTERS  REFERENCES
 *
 x  STACK/ HEAP     FUNCTIONAL PROGRAMMING

 x  Copy Constructor   DEPP copy        Constructor/Destructor/Copy c./Assignment operator with TRACE
 x
 x  Assertions are debug-only, so you can compile them out!
 x
 x  Use assertions to catch bugs - actual data errors, or logical/flow-control errors
 x
 x  g++ -DNDEBUG myprog.cc -o myprog
 *
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

class FloatVector
{
    int numElems;           // Size of the vector
    float *elems;           // Dynamically allocated array of vector's elements
    string name;
public:
    FloatVector() {FloatVector(100);}
    FloatVector(int n, const char *name = " default_name_");
    ~FloatVector();
    FloatVector(FloatVector const &); //copy constructor =>  deep copy

    FloatVector const& operator= (FloatVector &fv);

//    void prt(FloatVector &, char *narr = 0);    //  Prints
    void prt(int , char * ) const ;

    FloatVector& set(int, float);

    float get(int i) const    {
        return elems[i];
    }
    int getSz()  const    {
        return numElems;
    }
};

//===========================================================

FloatVector::FloatVector(int n, const char *nm)
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
FloatVector::FloatVector(FloatVector const &fv )  {                  //x     Copy-Constructor  - deep copy
    name += fv.name + "*CC";

    cout << "\n\n******   Copy constructor has been called...for  name = " << name << endl;
    numElems = fv.numElems;
//warn:  DON'T just copy the pointer value
    elems = new float[numElems];            // Allocate space
    for (int i = 0; i < numElems; i++)
        elems[i] = fv.elems[i];             // Copy the data over
}


FloatVector const & FloatVector:: operator= (FloatVector &fv)
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
FloatVector::~FloatVector() {                                       //x     Destructor
    cout << "\n\n*****     Destructor has been called.. for name = "  << this->name  <<endl;

    delete[] elems; // Release the memory for the array.
}

void prt(FloatVector &p, char *narr) {                 //x     Print
    cout << narr << " ";
    for (int i = 0; i < p.getSz(); i++)
        cout << p.get(i)  << ", ";

    cout << endl;
}

void FloatVector::prt(int ii, char *narr) const{                 //x     Print
    cout << narr << " - " << elems[ii] << "\n ";
}

FloatVector& FloatVector::set(int elNo, float val)           //x     Returning *this in Setter calls for Copy Constructor
{
    if(elNo >= numElems-1)
        assert(elNo);

    elems[elNo] = val;

    return *this;
}

void loopThruPt(FloatVector &vec, const char* lbl = "")
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
int main2fv()
{
    cout << "\nobjects    new/delete\n-----------------------\n";
    {
        cout << "Ex:  fv is a pointer to FloatVector instance\n";

        FloatVector *fv = new FloatVector(35,"*fv");     // allocating

//todo
//todo  ADD FUNCTION prtPoint   TO MAKE IT PRINTABLE ; do sth with setX, setY          11/12/18
//todo
//todo
//todo
//todo
        prt(*fv, const_cast<char *> ("This is a FloatVector object "));
        cout << "\n";
        fv->set(0,1.11);                       // Use the point -

        prt(*fv, const_cast<char *> ("This is a FloatVector after setting 0 elm to 1.11: "));
        cout << "\n";

        delete fv;                           // Free the point!.... warn....otherwise will be a leak
    }

//x  arrays of objects
    cout << "\narrays of objects\n---------------------\n";

//x  The new operator can also allocate arrays
    FloatVector *flVect = new FloatVector(14,"*fvVect");  // Index 0..13
    flVect->set(5,10.01).set(7, 500.0);

//
    {
        FloatVector tenPoints(10,"tenPoints(10)");                                      //      Index 0..9
        tenPoints.set(3,21.78).set(4,22.1).set(5,15.98).set(6,24.8).set(9, 0.06);         //x     building up


        prt(tenPoints, const_cast<char *> ("elm 3,4,5,6,10 with builder set... "));

//x     size-of
        cout << "\n\nflVect size [should be 14] = " << (sizeof(flVect)/sizeof(*flVect)) << endl;
//
        FloatVector *newVct_1 = new FloatVector(*flVect);     //x   should call copy constrictor

        newVct_1->set(2, 222);
        prt(*newVct_1,"newVect_1: ");

        prt(*flVect, const_cast<char *> ("\n newVct_1->set(2, 222) .. and   flVect  shall NOT be affected - 2 elms r expected"));
//--
        FloatVector newerVct_2;

        newerVct_2 = *newVct_1;   //x should be calling assignment operator

        cout << "\nnewerVect_2 has been initiated with newVct_1 by assignment op.  '='  ... with 3 elements " << endl;
        prt(newerVct_2, const_cast<char *> ("**** newerVect  shall have 3 elms\n"));

        prt(*newVct_1, const_cast<char *> ("\n\n**** newVect before newerVect change "));

        cout << "\n newerVect_2 has been added with 9.99 and 8.88   ... so it should have 5 elements " << endl;
        newerVct_2.set(7,9.99);        newerVct_2.set(8, 8.88);

        prt(*newVct_1, const_cast<char *> ("\n**** newVect_1 after newerVect change - shall have 3 elm"));
        prt(newerVct_2, const_cast<char *> ("\n**** newerVect_2 after change - shall have 5 elm"));

//x  Dynamically allocated arrays must be freed with
//x  delete[] operator!
//        delete[] flVect;                // Clean up my Points


        loopThruPt(*newVct_1, "+1+ newVct_1");
//
        loopThruPt(newerVct_2, "+2+ newerVct_2");

//Note : aatempting sizeOf
//      FloatVector *newVct_1 = new FloatVector(*flVect);       //x   should call copy constrictor
//      newerVct_2 = *newVct_1;                                 //x should be calling assignment operator
//        arraySize(newVct_1);
//
//        cout << "\n\nnewVct_1 size = " << (std::size(*flVect)) << endl;




    }


//x  allocate/deallocate  fvect is a local variable ... Its destructor is automatically called at end of block
    {
        FloatVector fvect(100,"fvect(100)"); // Use our vector

        string arS[55];
        arS[0] = "knknkknnknkknk";
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


        assert(sz == 32);//warn:   If condition is false, the program will halt.

    }   // <--- fvect’s destructor automatically called here.



    cout << "\n\ndone..." << endl;

    return 0;
}





/*
 *
C++ STACK and HEAP
------------------

 The Stack and The Heap

 Stack space is managed automatically
    * Space for a variable is allocated when it comes into scope
    * Space is reclaimed when it goes out of scope

 Stack space is limited to a (smallish) fixed size!

 int compute() {
    // Ten million integers for computation
      int array[10 * 1024 * 1024];
     ...
   }
 array is a local variable… stack overflow!!

 Can allocate much larger chunks of memory from “the heap”
  * Must manually allocate and release heap memory

 In C we use malloc() to allocate memory, and free() to release it
 In C++ we use new to allocate memory, and delete to release it
  * Result is a typed pointer, unlike malloc()
x * new and delete are operators in C++, not functions like malloc() / free()


 */