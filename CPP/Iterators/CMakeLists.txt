cmake_minimum_required(VERSION 3.12)
project(Iterators)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(Iterators
        Iterator_light_vers.cpp
        main_lec_3_4_floatVector_sizeOf.cpp
        utl.h)
