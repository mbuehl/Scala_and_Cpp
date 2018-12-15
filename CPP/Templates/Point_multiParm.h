//
// Created by ewa on 12/1/2018.
//

#ifndef TEMPLATES_POINTM_H
#define TEMPLATES_POINTM_H

#include<iostream>
#include <cmath>

template<typename T, int multply = 1> class PointMulti {
    T x_coord, y_coord;

public:
    PointMulti() : x_coord(0), y_coord(0) {}

    PointMulti(T x, T y) : x_coord(x), y_coord(y) {}

    T getX() const { return x_coord; }
    T getY() const { return y_coord; }

    void setX(T x) { x_coord = x; }

    T distanceTo(const PointMulti<T> &other, int scale = multply) const {
        T dx = scale * (x_coord - other.getX());
        T dy = scale * (y_coord - other.getY());

        return (T) sqrt((double) (dx * dx + dy * dy));
    }

//NOTE:  usually signature for overloading ostream& operator<<       (ostream& out,  const my_type& v )

//NOTE:  Both args are passed by reference -->  my_type is passed with const modifier as is not to be modified

    friend std::ostream& operator<<(std::ostream& out, const PointMulti& pt)
    {
        out << "(" << pt.x_coord << ", " << pt.y_coord <<")";
        return out;
    }


};




#endif //TEMPLATES_POINT_H


/*
 x Templates generally live entirely in .hh files
 x   Unlike normal classes, no code in .cc files
 x   Code that uses a template must see the entire  template definition

 x C++ compilers treat them like big macros…
 x   …with type-checking and many other capabilities.
 x   So, PointMulti template goes into PointMulti.hh

 x  All PointMulti code goes into PointMulti.hh

 x  No more PointMulti.cc, now that it’s a template

 --------------------------------------------------------------------------------

Warn:       Template Gotcha #1
x A major problem with templates:
x   You can’t explicitly state the requirements of what operations T must support.
x
x If someone uses a template with a type that doesn’t support the required operations:
x    You just see a bunch of cryptic compiler errors.
x
x When you write templates:
x   Clearly document what operations the template-parameters must support.
x
x If you use STL much, you will learn these things..





 */