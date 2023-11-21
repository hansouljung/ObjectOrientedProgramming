#include "Location.h"

Location::Location(const std::string& filename, int line)
    : _filename(filename), _line(line) {}

bool Location::operator==(const Location& rhs) const {
    return (_filename == rhs._filename) && (_line == rhs._line);
}

bool Location::operator!=(const Location& rhs) const {
    return !(*this == rhs);
}

bool Location::operator<(const Location& rhs) const {
    return (_filename == rhs._filename) ? (_line < rhs._line) : (_filename < rhs._filename);
}

bool Location::operator>(const Location& rhs) const {
    return (_filename == rhs._filename) ? (_line > rhs._line) : (_filename > rhs._filename);
}

bool Location::operator<=(const Location& rhs) const {
    return !(*this > rhs);
}

bool Location::operator>=(const Location& rhs) const {
    return !(*this < rhs);
}

std::ostream& operator<<(std::ostream& os, const Location& location) {
    return os << location._filename << " line " << location._line;
}
