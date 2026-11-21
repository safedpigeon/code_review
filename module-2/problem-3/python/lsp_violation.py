from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def get_area(self):
        pass

class Rectangle(Shape):
    def __init__(self, width, height):
        self._width = width
        self._height = height

    @property
    def width(self):
        return self._width

    @property
    def height(self):
        return self._height

    def get_area(self):
        return self._width * self._height

class Square(Shape):
    def __init__(self, side):
        self._side = side

    @property
    def side(self):
        return self._side

    def get_area(self):
        return self._side * self._side

def print_area(shape: Shape):
    print(f"Area: {shape.get_area()}")

if __name__ == "__main__":
    print("Testing with Rectangle:")
    print_area(Rectangle(5, 10))

    print("\nTesting with Square:")
    print_area(Square(5))
