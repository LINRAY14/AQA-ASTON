public class Exception {
    public static void main(String[] args) {

        String[][] matrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        processMatrix(matrix);
    }

    public static void processMatrix(String[][] matrix) {
        try {
            int sum = sumMatrix(matrix);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int sumMatrix(String[][] matrix) {
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть 4x4, но передан " + matrix.length + "x" + matrix[0].length);
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (matrix[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть 4x4, но строка " + i + " имеет размер " + matrix[i].length);
            }
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: " + matrix[i][j] + " (некорректные данные)");
                }
            }
        }
        return sum;
    }
}

class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super(message);
    }
}
