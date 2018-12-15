#ifndef REFERENCES_POINT_HH
#define REFERENCES_POINT_HH

#include <iostream>

/*
 x  REFERENCES  + casting string to char*  with:    const_cast<char *>
 *
 */


using namespace std;

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

    void rotate90(Point &p);

    void prtPoint(Point &, char *narr = 0);    //  Print coord
};


#endif
