/*
#include "Time.h"
#include <iomanip> 
#include <sstream>

Time::Time() : _hour(0), _minute(0), _second(0){
    // Default constructor sets the time to midnight (00:00:00)
}

Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second){
    rationalize();
}

Time Time::operator+(const Time& other) const{
    int newHour = _hour + other._hour;
    int newMinute = _minute + other._minute;
    int newSecond = _second + other._second;

    Time result(newHour, newMinute, newSecond);
    result.rationalize();
    return result;
}

Time& Time::operator++(){
    ++_second;
    rationalize();
    return *this;
}

Time Time::operator++(int){
    Time temp = *this;
    ++(*this);
    return temp;
}



bool Time::operator==(const Time& other) const{
    return compare(other) == 0;
}

bool Time::operator!=(const Time& other) const{
    return compare(other) != 0;
}

bool Time::operator<(const Time& other) const{
    return compare(other) < 0;
}

bool Time::operator>(const Time& other) const{
    return compare(other) > 0;
}

bool Time::operator<=(const Time& other) const{
    return compare(other) <= 0;
}

bool Time::operator>=(const Time& other) const{
    return compare(other) >= 0;
}

std::ostream& operator<<(std::ostream& ost, const Time& time) {
    ost << std::setw(2) << std::setfill('0') << time._hour << ':'
        << std::setw(2) << std::setfill('0') << time._minute << ':'
        << std::setw(2) << std::setfill('0') << time._second << '\'';
    return ost;
}



std::istream& operator>>(std::istream& ist, Time& time){
    char colon;
    ist >> time._hour >> colon >> time._minute >> colon >> time._second;
    time.rationalize();

    if (ist.fail() || colon != ':'){
        ist.setstate(std::ios::failbit);
    }

    return ist;
}



void Time::rationalize() {
    _minute += _second / 60;
    _second %= 60;

    _hour += _minute / 60;
    _minute %= 60;

    _hour %= 24;

    // Ensure leading zeros for single-digit hours, minutes, and seconds
    std::ostringstream ost;
    ost << std::setw(2) << std::setfill('0') << _hour << ':'
        << std::setw(2) << std::setfill('0') << _minute << ':'
        << std::setw(2) << std::setfill('0') << _second;

    std::string formattedTime = ost.str();
    std::istringstream iss(formattedTime);


    char colon1, colon2;
    iss >> _hour >> colon1 >> _minute >> colon2 >> _second;

    if (_second < 0) {
        _second += 60;
        _minute -= 1;
    }
}




int Time::compare(const Time& other) const{
    if (_hour != other._hour){
        return _hour - other._hour;
    }
    if (_minute != other._minute){
        return _minute - other._minute;
    }
    return _second - other._second;
}
*/

#include "Time.h"

#include <iomanip>

Time::Time(int hour, int minute, int second) : hour{hour}, minute{minute}, second{second} 
{ 
    rationalize(); // making sure time is rationalized after initializing it 
}

Time::Time() : hour{0}, minute{0}, second{0} {} // default constructor for time 00:00:00 (midnight)

Time Time::operator+(const Time& other) const
{
    Time result{hour + other.hour, minute + other.minute, second + other.second};
    result.rationalize();
    return result;
}

Time& Time::operator++() // before incrementing
{
    ++second;
    rationalize();
    return *this;
}

Time Time::operator++(int) // after incrementing
{
    Time result{*this};
    ++second;
    rationalize();
    return result;
}

bool Time::operator==(const Time& other) const
{
    return hour == other.hour && minute == other.minute && second == other.second;
}

bool Time::operator!=(const Time& other) const
{
    return !(*this == other);
}

bool Time::operator<(const Time& other) const
{
    if (hour != other.hour)
    {
        return hour < other.hour;
    }
    else if (minute != other.minute)
    {
        return minute < other.minute;
    }
    else
    {
        return second < other.second;
    }  
}

bool Time::operator>(const Time& other) const
{
    return (other < *this);
}

bool Time::operator<=(const Time& other) const
{
    return !(*this > other);
}

bool Time::operator>=(const Time& other) const
{
    return !(*this < other);
}

std::ostream& operator<<(std::ostream& os, const Time& time)
{
    os << std::setfill('0') << std::setw(2) << time.hour << ":"
       << std::setfill('0') << std::setw(2) << time.minute << ":"
       << std::setfill('0') << std::setw(2) << time.second;
    return os;
}



std::istream& operator>>(std::istream& is, Time& time)
{
    char colon;
    // reading input in correct format
    if (is >> std::setw(2) >> time.hour >> colon >> std::setw(2) >> time.minute >> colon >> std::setw(2) >> time.second)
    {
        if (colon == ':') // checking if colon is in correct position
        {
            return is;
        }
        else
        {
            is.setstate(std::ios::failbit); // if colon is not in correct position, set failbit
        } 
    }
    else 
    {
        is.setstate(std::ios::failbit);
    }
    return is;
}

void Time::rationalize()
{
    minute += second / 60; // converting excess seconds to minutes
    second %= 60; // making sure seconds are between 0 and 59

    if (second < 0)
    {
        --minute; // if seconds are negative, decrement minute
        second += 60; // add seconds to be positive
    }

    hour += minute / 60; // converting excess minutes to hours
    minute %= 60; // making sure minutes are between 0 and 59

    if (minute < 0)
    {
        --hour; // if minutes are negative, decrement hour
        minute += 60; // add minutes to be positive
    }

    hour %= 24; // making sure hours are between 0 and 23
}
