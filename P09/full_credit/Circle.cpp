#include "Circle.h"
#include <cmath>

Circle::Circle(double radius) : radius(radius){}

std::string Circle::name(){
    return "Circle of radius " + std::to_string(radius);
}

double Circle::area(){
    return M_PI * radius * radius; // Using pi from the <cmath> library
}
