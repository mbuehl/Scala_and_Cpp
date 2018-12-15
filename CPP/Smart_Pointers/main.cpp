#include <iostream>

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}


/*
NOTE:       http://ootips.org/yonat/4dev/smart-pointers.html

x  Why: Garbage collection  -- smart pointers can be used for that purpose. The simplest garbage collection scheme is reference counting or reference linking, but it is quite possible to implement more sophisticated garbage collection schemes with smart pointers
x  Why: Efficiency          --
x
x  As you can see, auto_ptr is a simple wrapper around a regular pointer. It forwards all meaningful operations
x  to this pointer (dereferencing and indirection).
x  Its smartness in the destructor: the destructor takes care of deleting the pointer.
x
x   For the user of auto_ptr, this means that instead of writing:
x
x    void foo()
x    {
x        MyClass* p(new MyClass);
x        p->DoSomething();
x        delete p;
x    }
x
x   You can write:
x
x    void foo()
x    {
x        auto_ptr<MyClass> p(new MyClass);
x        p->DoSomething();
x    }
x
x
x
x
x
x
 */