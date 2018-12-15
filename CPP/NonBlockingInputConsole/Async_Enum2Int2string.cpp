#include <iostream>
#include <future>
#include <thread>
#include <chrono>
#include <windows.h>



static std::string getAnswer()
{
    std::cout << "\n** START:  getAnswer() " << std::endl;
    std::string answer;
    std::cin >> answer;
    return answer;      //Warn:  return by value - so copy will be made  otherwise would be the LOCAL SCOPE
}

void showCnt()
{
    std::cout << "\n** START:  showCnt() " << std::endl;
    long lCNT = 0;
    while (true) //answer == "maybe")
    {
        std::cout << lCNT++ <<",";// <<   "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" ;
        Sleep(1000);
    }
}



int main()
{
    std::cout << "--> Non-blocking console input in C++ " << std::endl<< std::endl;

    int timeout = 17;
    std::cout << "do you even lift?  " ;
//x--
    std::string answer = "maybe"; //default to maybe
//x--
    std::future<std::string> future = std::async(getAnswer);        //Warn:  async is not a separate thread
//x--
    std::future<void> future2 = std::async(showCnt);
//x--
    std::cout << "\n1 - non-blocking" << std::endl;


    std::cout << "\n2 - non-blocking" << std::endl;
    Sleep(500);
    std::cout << "\n3 - BLOCKS on: future.wait_for(std::chrono::seconds(timeout)) == std::future_status::ready" << std::endl;


    std::future_status status;
    if ( ( status = future.wait_for(std::chrono::seconds(timeout)) ) == std::future_status::ready)
        answer = future.get();

    int sta =   (int)(status);           //std::to_string<std::future_status>(status);

    std::cout << "\n\n.Got THE answer ..." << (sta==0? (" The answer was keyed in as: " + answer):
                    " TimeOut has occurred ....")  << std::endl;

    std::cout << "\n99   T h e   E N D " << std::endl;
    exit(0);
}

