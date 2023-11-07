#include "Rectangle.h"

Rectangle::Rectangle(double height, double width) : height(height), width(width) {}

std::string Rectangle::name(){
    return "Rectangle of height " + std::to_string(height) + " and width " + std::to_string(width);
}

double Rectangle::area(){
    return height * width;
}
