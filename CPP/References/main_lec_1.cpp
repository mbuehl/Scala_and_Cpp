#include <iostream>

/*
 x  REFERENCES  + casting string to char*  with:    const_cast<char *>
 *
 */
#include "point_df.h"

using namespace std;

/*
class Point {
    double x_coord, y_coord;// Data-members
public:
                                                // Constructors
    Point(){                                    // C way
        x_coord = 0.0;
        y_coord = 0.0;
    }

    Point(double x, double y) : x_coord(x),y_coord(y){}         //C++ way

    ~Point(){                                   // Destructor
// no dynamically allocated resources, so doesn't do anything
    }

    double getX()  {return x_coord;}            // Accessors
    double getY()  {return y_coord;}            // Accessors

                                                // Mutators
    void setX(double x);
    void setY(double y);

    void outputPoint(Point &, char *narr = 0);    //  Print coord
};

void rotate90(Point &p) {
    double x = p.getX();
    double y = p.getY();
    p.setX(y);
    p.setY(-x);
}

void Point::outputPoint(Point &p, char* narr) {
    cout << narr << "(" << p.getX()
         << "," << p.getY() << ")";
}

void Point::setX(double x_coord) {
    Point::x_coord = x_coord;
}

void Point::setY(double y_coord) {
    Point::y_coord = y_coord;
}
*/
int main1()
{
    {
        cout << "The referent can be changed – just like a pointer\n";

        int i = 5;
        int &j = i;         // j is a reference to i
        j++;                // i == 6 now, too
        cout << " i=5;  &j = i;  j++;   'i' value is changed as well    i: " << i << endl;
    }

    {
        cout <<  "\nMuch cleaner syntax than pointers!\n" << "Same contrived example, with pointers\n\n";

        int i = 5;
        int *j = &i;        // j is a pointer to i
        (*j)++;             // parentheses are necessary here

        cout << " i=5;  &j = i;  (*j)++;  !wrapping in parenthesis is required!     'i' value is changed as well  i: "
                << i << endl;
    }

    {
        cout << "\nCan use references to primitive variables or objects\n";

        cout << "   float &f is a reference to a float primitive\n" <<
                "   Point &p is a reference to a Point object\n";

        cout<< "\nAlways use object references as function arguments\n" <<
                "  The object itself isn’t copied, so it’s much faster\n"<<
                " ! Conversion from variable to reference is automatic\n\n" <<
                "     void outputPoint(Point &p) { ... }"<<
                "   // No extra syntax needed to pass loc to fn.\n"<<
                "     Point loc(35, -117);\n"<<
                "     outputPoint(loc);\n\n";

        cout << "Don’t use references for primitive types (usually)\n" <<
                "   Doesn’t save any time\n" <<
                "   Best to avoid, except in very special circumstances\n\n";

        cout << "Example: a function that takes a Point argument\n" <<
                " Modify the point in-place to rotate it by 90°\n" <<
                " Want the function to actually change the passed-in object\n";

        Point f(5, 2);


//Warn:  need to cast string to  const_cast<char *>  as ISO standard does not allow conversion from string to char*

        char* bef = const_cast<char *>("\nbefore rotating: ");

        f.prtPoint(f, bef);
        f.rotate90(f);

        f.prtPoint(f, const_cast<char *> ("\nafter rotating: "));

    }



    cout << "\n\ndone..." << endl;

    return 0;
}

/*
 *
C++ introduces references
--------------------------
 A reference is like an alias for a variable. Using the reference is exactly like using what it refers to

 Updating our function:

 void outputPoint(Point &p) {
     cout << "(" << p.getX() << "," << p.getY() << ")";
 }
...
 Point loc(35,-117);
 outputPoint(loc); // loc is passed "by-reference"....no copying is made

" p is of type Point & - “reference to a Point object”
" Using p is identical to using loc here *

 */