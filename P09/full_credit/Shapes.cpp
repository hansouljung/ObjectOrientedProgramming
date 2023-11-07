#include <iostream>
#include "Shape.h"
#include "Circle.h"
#include "Rectangle.h"
#include <vector>

int main() {
    std::vector<Shape*> shapes;

    Circle circle(2.0);
    Rectangle rectangle(3.0, 4.0);

    shapes.push_back(&circle);
    shapes.push_back(&rectangle);

    for (Shape* shape : shapes){
        std::cout << shape->to_string() << std::endl;
    }

    return 0;
}
