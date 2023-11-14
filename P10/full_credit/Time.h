/*
#ifndef TIME_H
#define TIME_H

#include <iostream>

class Time{
private:
    int _hour;
    int _minute;
    int _second;

public:
    Time(); 
    Time(int hour, int minute, int second);

    Time operator+(const Time& other) const;
    Time& operator++();
    Time operator++(int);
    bool operator==(const Time& other) const;
    bool operator!=(const Time& other) const;
    bool operator<(const Time& other) const;
    bool operator>(const Time& other) const;
    bool operator<=(const Time& other) const;
    bool operator>=(const Time& other) const;
    
    friend std::ostream& operator<<(std::ostream& ost, const Time& time);
    friend std::istream& operator>>(std::istream& ist, Time& time);

private:
    void rationalize();
    int compare(const Time& other) const; // Optional
};

#endif // TIME_H

*/
#ifndef TIME_H
#define TIME_H

#include <iostream>

class Time {
private:
    int hour;
    int minute;
    int second;

public:
    Time(int hour, int minute, int second);
    Time();  // default constructor for time 00:00:00 (midnight)
    Time operator+(const Time& other) const;
    Time& operator++(); // before incrementing
    Time operator++(int); // after incrementing
    bool operator==(const Time& other) const;
    bool operator!=(const Time& other) const;
    bool operator<(const Time& other) const;
    bool operator>(const Time& other) const;
    bool operator<=(const Time& other) const;
    bool operator>=(const Time& other) const;

    friend std::ostream& operator<<(std::ostream& os, const Time& time);
    friend std::istream& operator>>(std::istream& is, Time& time);

private:
    void rationalize();
};

#endif