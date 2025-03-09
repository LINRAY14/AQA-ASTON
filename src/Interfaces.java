    interface Shape {

    double calculateArea();
        double calculatePerimeter();

        default void displayCharacteristics(String fillColor, String borderColor) {
            System.out.println("Площадь: " + calculateArea());
            System.out.println("Периметр: " + calculatePerimeter());
            System.out.println("Цвет заливки: " + fillColor);
            System.out.println("Цвет границы: " + borderColor);
            System.out.println();
        }

        void displayInfo();
    }
    class Circle implements Shape {
        private double radius;
        private String fillColor;
        private String borderColor;

        public Circle(double radius, String fillColor, String borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculateArea() {

            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        public void displayInfo() {
            System.out.println("Круг:");
            displayCharacteristics(fillColor, borderColor);
        }
    }

    class Rectangle implements Shape {
        private double width, height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        public void displayInfo() {
            System.out.println("Прямоугольник:");
            displayCharacteristics(fillColor, borderColor);
        }
    }

    class Triangle implements Shape {
        private double a, b, c;
        private String fillColor;
        private String borderColor;

        public Triangle(double a, double b, double c, String fillColor, String borderColor) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculateArea() {
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double calculatePerimeter() {
            return a + b + c;
        }

        public void displayInfo() {
            System.out.println("Треугольник:");
            displayCharacteristics(fillColor, borderColor);
        }
    }
    public class Interfaces {
        public static   void main(String[] args) {
            Shape circle = new Circle(5, "Красный", "Черный");
            Shape rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
            Shape triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");

            circle.displayInfo();
            rectangle.displayInfo();
            triangle.displayInfo();
        }
    }

