public class Factorial {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным!");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            if (Long.MAX_VALUE / result < i) {
                throw new ArithmeticException("Факториал слишком большой, произойдёт переполнение!");
            }
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Факториал 5: " + factorial(5));
        System.out.println("Факториал 10: " + factorial(10));
    }
}
