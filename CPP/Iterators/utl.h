//
// Created by ewa on 11/23/2018.
//
//x     https://bytes.com/topic/c/answers/544209-std-string-c_str-const_cast-char
//
//
//

#ifndef ITERATORS_UTL_H
#define ITERATORS_UTL_H


#include <string>

const char* s2c(const std::string &s)
{
    return s.c_str();
//    return   const_cast<char *>(s);
}


#endif //ITERATORS_UTL_H

/*
 *

Here is a highly simplified but hopefully relevant view of what happens when you build your code in C++.

C++ splits the load of generating machine executable code in following different phases -

    Preprocessing - This is where any macros - #defines etc you might be using get expanded.

    Compiling - Each cpp file along with all the #included files in that file directly or indirectly
    (together called a compilation unit) is converted into machine readable object code.

    This is where C++ also checks that all functions defined (i.e. containing a body in { }
    e.g. void Foo( int x){ return Boo(x); }) are referring to other functions in a valid manner.

    The way it does that is by insisting that you provide at least a declaration of these other functions
    (e.g. void Boo(int); ) before you call it so it can check that you are calling it properly among other things.
    This can be done either directly in the cpp file where it is called or usually in an included header file.

    Note: that only the machine code that corresponds to functions defined in this cpp and included files gets built
        as the object (binary) version of this compilation unit (e.g. Foo) and not the ones that are merely
        declared (e.g. Boo).

    Linking - This is the stage where C++ goes hunting for stuff declared and called in each compilation
    unit and links it to the places where it is getting called.
    Now if there was no definition found of this function the linker gives up and errors out.
    Similarly if it finds multiple definitions of the same function signature (essentially the name
    and parameter types it takes) it also errors out as it considers it ambiguous and doesn't want to pick one arbitrarily.

The latter is what is happening in your case. By doing a #include of the fun.cpp file, both fun.cpp and mainfile.cpp
 have a definition of funct() and the linker doesn't know which one to use in your program and is complaining about it.

The fix as Vaughn mentioned above is to not include the cpp file with the definition of funct()
in mainfile.cpp and instead move the declaration of funct() in a separate header file and include that in mainline.cpp

This way the compiler will get the declaration of funct() to work with and the linker would get just
 one definition of funct() from fun.cpp and will use it with confidence.

 *
 *
 *
 */