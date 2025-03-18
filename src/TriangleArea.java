public class TriangleArea {

    public static double triangleArea(double a, double b, double c) {
    if (a <= 0 || b <= 0 || c <= 0) {
        throw new IllegalArgumentException("Стороны должны быть положительными!");
    }
    double s = (a + b + c) / 2;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
}

    public static void main(String[] args) {
        System.out.println("Площадь треугольника: " + triangleArea(6, 8, 10));
    }
}
