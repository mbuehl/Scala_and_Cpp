cmake_minimum_required(VERSION 3.12)
project(References)

set(CMAKE_CXX_STANDARD 17)

add_executable(References main_lec_1.cpp main_lec_2.cpp point_df.h point_df.cpp main_lec_2_floatVector.cpp
        CopyConstrVSAssignOp.cpp main_lec_3_4_floatVector_sizeOf.cpp 
        CNV_str2charPtr.cpp CNV_charPtr2str.cpp)