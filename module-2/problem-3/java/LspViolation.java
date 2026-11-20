package module2.problem3;

public class LspViolation {
    public static class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int getArea() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            super.setWidth(width);
            super.setHeight(width);
        }

        @Override
        public void setHeight(int height) {
            super.setWidth(height);
            super.setHeight(height);
        }
    }

    public static void resize(Rectangle rect) {
        rect.setWidth(5);
        rect.setHeight(10);
        // For a rectangle, area should be 5 * 10 = 50
        if (rect.getArea() != 50) {
            System.out.println("LSP Violation detected! Expected area 50, but got " + rect.getArea());
        } else {
            System.out.println("Area is correct: " + rect.getArea());
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing with Rectangle:");
        resize(new Rectangle());

        System.out.println("\nTesting with Square:");
        resize(new Square());
    }
}
