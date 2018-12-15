#include <iostream>
#include "stdlib.h"
#include <cassert> // assert.h in C    Error is displayed, with line number of failure.


//Assertions are debug-only, so you can compile them out!
//  g++ -DNDEBUG myprog.cc -o myprog
// Use assertions to catch bugs - actual data errors, or logical/flow-control errors

/*
 x  POINTERS        COPYING CONSTRUCTOR
 *
 x  STACK/ HEAP     FUNCTIONAL PROGRAMMING

 x  Copy Constructor   DEPP copy

 x  Assertions
 *
 */
#include "point_df.h"

using namespace std;

/*
 x When a class dynamically allocates memory:

 x    Do the allocation in the constructor(s)
 x    Release memory in the destructor

*/

void loopThruPt(Point *newPoint, const char* lbl = "")
{
    cout <<  "\n*\n" <<lbl << "  !!! loopThruPt !!!" << endl;

    for(int i =0; i< 14;i++)
    {
        string str = "\nelm ";
        char cnv[20];
        sprintf(cnv,"%d",i);
        str += cnv;
        str +=  "th****after: ";
        newPoint->prtPoint(newPoint[i], (char *) str.c_str());
    }

}


int main2()
{
    cout << "\nobjects    new/delete\n-----------------------\n";
    {
        cout << "Ex:  p is a pointer to the Point instance\n";

        Point *p = new Point(3.5, 2.1);     // allocating

        p->prtPoint(*p, const_cast<char *> ("This is a point: "));
        cout << "\n";
        p->setX(3.8);                       // Use the point -

        p->prtPoint(*p, const_cast<char *> ("This is a point after setting X to 3.8: "));
        cout << "\n";

        delete p;                           // Free the point!.... warn....otherwise will be a leak
    }

//x  arrays of objects
    cout << "\narrays of objects\n---------------------\n";

//x  The new operator can also allocate arrays
    Point *somePoints = new Point[14];  // Index 0..13
    somePoints[5].setY(-14.4); somePoints[5].setX(1.85);        // 6th element
    somePoints[11].setY(1.5);                                   // 12th element
//
    {
        Point tenPoints[10];                // Index 0..9
        tenPoints[3].setX(21.78);           // Fourth element


        somePoints->prtPoint(somePoints[11], const_cast<char *> ("elm 12th: "));

        cout << "\n\nsomePoints size = " << (sizeof(somePoints)) << endl;

        Point *newPoint (somePoints);

//--
        Point *newerPoint = somePoints;
        newerPoint[7].setX(9.99);        newerPoint[7].setY(8.888);

        newPoint->prtPoint(newPoint[11], const_cast<char *> ("\n****bef elm 12th: "));
//x  Dynamically allocated arrays must be freed with
//x  delete[] operator!
        delete[] somePoints;                // Clean up my Points

//
//        for(int i =0; i< 14;i++)
//        {
//            string str = "\nelm ";
//            char cnv[20];
//            sprintf(cnv,"%d",i);
//            str += cnv;
//            str +=  "th****after: ";
//            newPoint->prtPoint(newPoint[i], (char *) str.c_str());
//        }
        loopThruPt(newPoint, "+1+ newPoint");

        loopThruPt(newerPoint, "+2+ newerPoint");

        cout << "\n\nnewPoint size = " << (sizeof(newPoint)) << endl;

        delete newPoint;
        delete newerPoint;

    }
//x  allocate/deallocate  fvect is a local variable ... Its destructor is automatically called at end of block
    {
        //FloatVector fvect(100); // Use our vector

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


        assert(/*condition*/ sz == 55);//warn:   If condition is false, the program will halt.

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