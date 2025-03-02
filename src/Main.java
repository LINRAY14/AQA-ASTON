import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSumRange();
        checkNumberSign();
        checkNegativeNumber();
        repeatString();
        checkLeapYear();
        invertArray();
        secondArray();
        thirdArray();
        arrayMatrix();
        createArrayWithValues();

    }

    // Задание 1
    public static void printThreeWords() {
        System.out.println("Task_1:");
        String[] words = {"Orange", "Banana", "Apple"};
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println();
    }

    // Задание 2
    public static void checkSumSign() {
        System.out.println("Task_2:");
        int a = 5;
        int b = -10;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println();
    }

    // Задание_3
    public static void printColor() {
        System.out.println("Task_3:");
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
        System.out.println();
    }

    // Задание_4
    public static void compareNumbers() {
        System.out.println("Task_4:");
        int a = 7;
        int b = 14;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
        System.out.println();
    }

    // Задание_5
    public static void checkSumRange() {
        System.out.println("Task_5:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        boolean result = isSumInRange(a, b);
        System.out.println("Результат: " + result);
        System.out.println();
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    //Задание 6
    public static void checkNumberSign() {
        System.out.println("Task_6:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
        System.out.println();
    }
    //Задание 7
    public static void checkNegativeNumber() {
        System.out.println("Task_7:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        boolean result = number < 0;
        System.out.println("Результат: " + result);
        System.out.println();
    }
    // Задание 8
    public static void repeatString() {
        System.out.println("Task_8:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String text = scanner.nextLine();

        System.out.print("Введите количество повторений: ");
        int count = scanner.nextInt();

        printStringMultipleTimes(text, count);
        System.out.println();
    }

    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    // Задание_9
    public static void checkLeapYear() {
        System.out.println("Task_9:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        boolean isLeap = isLeapYear(year);
        System.out.println("Год " + year + " является високосным: " + isLeap);
        System.out.println();
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    // Задание_10
    public static void invertArray() {
        System.out.println("Task_10:");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Исходный массив:");
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }

        System.out.println("Измененный массив:");
        printArray(array);
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    //Задание 11
    public static void secondArray() {
        System.out.println("Task_11:");
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        printArray(array);
        System.out.println();
    }
    //Задание 12
    public static void thirdArray() {
        System.out.println("Task_12:");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        printArray(array);
        System.out.println();
    }
    //Задание 13
    public static void arrayMatrix() {
        System.out.println("Task_13:");
        int size = 8;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }

        printMatrix(matrix);
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    // Задание_14
    public static void createArrayWithValues() {
        System.out.println("Task_14:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int len = scanner.nextInt();

        System.out.print("Введите значение для всех элементов массива: ");
        int initialValue = scanner.nextInt();

        int[] array = generateArray(len, initialValue);
        printArray(array);
        System.out.println();
    }

    public static int[] generateArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }



}



