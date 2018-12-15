#include <iostream>

#include "Point.h"
#include "Point_multiParm.h"

int main()
{
    Point<float> pF(3.2, 5.1); // Float coordinates

    Point<int> pInt(15, 6); // Integer coordinates

    std::cout << pF << std::endl;

    std::cout << pInt << std::endl;


    PointMulti<float, 100> pFmulti(3.2, 5.1);

    const PointMulti<float> pFmulti2(3.25, 5.0); // Float coordinates

    std::cout << pFmulti.distanceTo( pFmulti2) << std::endl;


    return 0;
}