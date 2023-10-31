#include <iostream>
#include <string>

int main(){
	std::string name;
	std::cout<< "What's your name? ";
	//std::cin>> name; //scanf in C but only takes one word
	std::getline(std::cin, name);

	std::cout<< "Hello, " << name << "!" <<std::endl;

	return 0;

	//
}