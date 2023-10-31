#include <iostream>
#include <vector>
#include <string>

int main(int argc, char* argv[]) {
    //create vectors to hold std::string objects
    std::vector<std::string> caps;
    std::vector<std::string>* no_caps = new std::vector<std::string>();

    //iterating over program arguments
    for (int i = 1; i < argc; i++) {
        std::string arg = argv[i];
        if (!arg.empty()) {
            //check if the argument starts with an uppercase letter
            if (isupper(arg[0])) {
                caps.push_back(arg);
            } else {
                no_caps->push_back(arg);
            }
        }
    }

    //print the elements of each vector
    std::cout << "Capitalized:" << std::endl;
    for (const std::string& word : caps) {
        std::cout << word << std::endl;
    }

    std::cout << "\nLower Case:" << std::endl;
    for (const std::string& word : *no_caps) {
        std::cout << word << std::endl;
    }

    //clean up the dynamically allocated vector
    delete no_caps;

    return 0;
}
