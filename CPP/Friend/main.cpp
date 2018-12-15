#include <iostream>
//
//https://stackoverflow.com/questions/6255825/what-operators-should-be-declared-as-friends
//
class Message {
    std::string content;
public:
    Message(const std::string& str){ content = str;}
    bool operator==(const std::string& rhs) const {
        return content == rhs;
    }
    std::string get() {        return content;    }
        };
//allows you to compare a message to a string

void * cmp(Message&  Msg , const std::string & msg){
    if (Msg.get() == msg)
        std::cout << msg << "  is equal...."<<   std::endl;
    else
        std::cout << msg << "  is NOT equal...."<<   std::endl;

}

int main()
{
    std::cout << "For example, allows you to compare a message to a string..." << std::endl;

    Message message("Test");
    std::string msg("Test");
    std::string msg2("tesT");
    std::string msg3("test xcd");



    if (message == msg)
        std::cout << msg << "  is equal...."<<   std::endl;
    else
        std::cout << msg << "  is NOT equal...."<<   std::endl;

    cmp(message, msg );
    cmp(message, msg2 );
    cmp(message, msg3 );

    std::cout << "\n\nbut not the other way around.... if (msg == message) { // this won't compile  " << std::endl;
    std::cout << "\n\nYou'll need to declare a friend operator== inside the class:" << std::endl;
    std::cout << "\n -> friend bool operator==(const std::string& lhs, const Message& rhs);" << std::endl;

    return 0;
}




/*Warn              F r i e n d

x ->  when an operator must be declared as friend and when it should be declared as member          ?
x ->  What are the operators that will most often need to be declared as friends besides == and <<  ?



x    This really depends on whether a class is going to be on the left- or right-hand side of the call
x    to operator == (or other operator).
x
x    If a class is going to be on the right-hand side of the expression—and does not provide an implicit
x    conversion to a type that can be compared with the left-hand side—you need to implement operator==
x    as a separate function or as a friend of the class.
x
x    If the operator needs to access private class data, it must be declared as a friend.

 */