#include <iostream>

#include "point_df.h"

using namespace std;


void Point::rotate90(Point &p) {
    double x = p.getX();
    double y = p.getY();
    p.setX(y);
    p.setY(-x);
}

void Point::prtPoint(Point &p, char *narr) {
    cout << narr << "(" << p.getX()
         << "," << p.getY() << ")";
}

void Point::setX(double x_coord) {
    Point::x_coord = x_coord;
}

void Point::setY(double y_coord) {
    Point::y_coord = y_coord;
}
