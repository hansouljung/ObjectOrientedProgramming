#ifndef INDEX_H
#define INDEX_H

#include <iostream>
#include <map>
#include <set>
#include <string>
#include "Location.h"

class Index {
private:
    using Word = std::string;
    using Locations = std::set<Location>;
    std::map<Word, Locations> _index;

public:
    void add_word(const Word& word, const std::string& filename, int line);
    friend std::ostream& operator<<(std::ostream& os, const Index& index);
};

#endif // INDEX_H
