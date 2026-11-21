package module2.problem3;

public class LspViolation {
    public interface Shape {
        int getArea();
    }

    public static class Rectangle implements Shape {
        private final int width;
        private final int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int getArea() {
            return width * height;
        }
    }

    public static class Square implements Shape {
        private final int side;

        public Square(int side) {
            this.side = side;
        }

        public int getSide() {
            return side;
        }

        @Override
        public int getArea() {
            return side * side;
        }
    }

    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    public static void main(String[] args) {
        System.out.println("Testing with Rectangle:");
        printArea(new Rectangle(5, 10));

        System.out.println("\nTesting with Square:");
        printArea(new Square(5));
    }
}
