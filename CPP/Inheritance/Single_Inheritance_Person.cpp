//
// Created by ewa on 11/25/2018.
//

//Todo 2018/11/25: want to initiate also the base class - Person values while initiating Employee
//

#include "Single_Inheritance_Person.h"


#include <iostream>
#include <string>

class Person
{
public:
    std::string m_name;
    int m_age;

    std::string getName() const { return m_name; }
    int getAge() const { return m_age; }

    Person(std::string name = "", int age = 0)
            : m_name(name), m_age(age)
    {
    }
};

//x     Employee publicly inherits from Person
class Employee: public Person
{
public:
    double m_hourlySalary;
    long m_employeeID;

    Employee(double hourlySalary = 0.0, long employeeID = 0)
            : m_hourlySalary(hourlySalary), m_employeeID(employeeID) , Person("xxxxxx",31)
    {
    }

    void printNameAndSalary() const
    {
        std::cout << "\nName: " << m_name << "  Salary: " << m_hourlySalary << "  Age: " << m_age << "  ID: " << m_employeeID << "\n\n";
    }
};

int main()
{
    Employee emp(20.25, 12345) ;

    emp.printNameAndSalary();
//todo :  Explain can we initialize base class at the same time ?  e.g. Employee emp(20.25, 12345)  ("Ala", 15);

    Employee frank (22.5,12346){("kk")};

    frank.m_name = "Frank";             // we can do this because m_name is public

    frank.printNameAndSalary();

    return 0;
}