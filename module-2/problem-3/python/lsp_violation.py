class Rectangle:
    def __init__(self):
        self.width = 0
        self.height = 0

    def set_width(self, width):
        self.width = width

    def set_height(self, height):
        self.height = height

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def get_area(self):
        return self.width * self.height

class Square(Rectangle):
    def set_width(self, width):
        self.width = width
        self.height = width

    def set_height(self, height):
        self.width = height
        self.height = height

def resize(rect):
    rect.set_width(5)
    rect.set_height(10)
    # For a rectangle, area should be 5 * 10 = 50
    if rect.get_area() != 50:
        print(f"LSP Violation detected! Expected area 50, but got {rect.get_area()}")
    else:
        print(f"Area is correct: {rect.get_area()}")

if __name__ == "__main__":
    print("Testing with Rectangle:")
    resize(Rectangle())

    print("\nTesting with Square:")
    resize(Square())
