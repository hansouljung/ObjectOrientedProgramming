#include "Index.h"

void Index::add_word(const Word& word, const std::string& filename, int line) {
    auto it = _index.find(word);
    if (it == _index.end()) {
        // Word not found, insert a new entry
        Locations locations;
        locations.insert(Location(filename, line));
        _index.insert({word, locations});
    } else {
        // Word found, insert the location into the existing set
        it->second.insert(Location(filename, line));
    }
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    for (const auto& entry : index._index) {
        os << entry.first << ": ";

        auto it = entry.second.begin();
        while (it != entry.second.end()) {
            os << *it;
            ++it;

            if (it != entry.second.end()) {
                os << ", ";
            }
        }

        os << "\n";
    }
    return os;
}

