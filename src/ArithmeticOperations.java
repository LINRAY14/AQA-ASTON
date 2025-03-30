public class ArithmeticOperations {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль запрещено!");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        System.out.println("Сложение: " + add(1, 2));
        System.out.println("Вычитание: " + subtract(2, 1));
        System.out.println("Умножение: " + multiply(2, 2));
        System.out.println("Деление: " + divide(4, 2));
    }
}
