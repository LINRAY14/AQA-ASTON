public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie_1:");
        printThreeWords();

        System.out.println("\nZadanie_2:");
        checkSumSign();

        System.out.println("\nZadanie_3:");
        printColor();

        System.out.println("\nZadanie_4:");
        compareNumbers();

        System.out.println("\nZadanie_5:");
        System.out.println(isSumInRange(5, 10)); // true
        System.out.println(isSumInRange(2, 3));  // false

        System.out.println("\nZadanie_6:");
        checkNumber(-5);
        checkNumber(10);

        System.out.println("\nZadanie_7:");
        System.out.println(isNegative(-10)); // true
        System.out.println(isNegative(0));   // false
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = -10;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 75;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 13;
        int b = 12;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkNumber(int num) {
        if (num >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }
}
