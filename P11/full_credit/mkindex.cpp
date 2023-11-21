#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include "Index.h"


void cleanup_word(std::string& word) {
    // Remove punctuation from the beginning
    while (!word.empty() && std::ispunct(word.front())) {
        word.erase(0, 1);
    }

    // Remove punctuation from the end
    while (!word.empty() && std::ispunct(word.back())) {
        word.pop_back();
    }

    // Convert the word to lowercase
    std::transform(word.begin(), word.end(), word.begin(), ::tolower);
}




int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " file1 file2 ... fileN\n";
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error opening file: " << argv[i] << "\n";
            continue;
        }

        std::string line;
        int line_number = 1;
        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;

            while (iss >> word) {
                cleanup_word(word);

                index.add_word(word, argv[i], line_number);
            }

            line_number++;
        }

        file.close();
    }

    std::cout << index;

    return 0;
}
