#include <iostream>

class Shape
{
public:
  virtual int get_area() = 0;
  void set_width(int w)
  {
    width = w;
  }
  void set_height(int h)
  {
    height = h;
  }
protected:
  int width;
  int height;
};

class Rectangle : public Shape
{
public:
  int get_area()
  {
    return (width * height);
  }
};

class Triangle : public Shape
{
public:
  int get_area()
  {
    return (width * height) / 2;
  }
};

int main(void)
{
  Rectangle rect;
  Triangle tri;

  rect.set_width(5);
  rect.set_height(7);

  std::cout << "Total Rectangle area: " << rect.get_area() << std::endl;

  tri.set_width(5);
  tri.set_height(7);

  std::cout << "Total Triangle area: " << tri.get_area() << std::endl;

  return 0;
}
