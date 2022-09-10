package FirstLesson;

/**
 * Задача 4.
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 * каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 * Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше
 */
public class Task4 {
    /**
     * Тестирование метода
     */
    public static void testTask() {
        try {
            var arr = arrayDivide(null, new int[]{});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            var arr = arrayDivide(new int[]{3, -4, 5}, new int[]{1, 2, -3});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            var arr = arrayDivide(new int[]{}, new int[]{1, 2, 3});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            var arr = arrayDivide(new int[]{3, 9, 8}, new int[]{1, 2, 0});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            var arr = arrayDivide(new int[]{3, 9, 8}, new int[]{1, 2, 3, 9});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /**
     * Метод деления элементов двух равных массивов попарно
     * @param firstArray целочисленный массив - делимое
     * @param secondArray целочисленный массив - делитель
     * @return целочисленный массив - частное
     */
    private static int[] arrayDivide(int[] firstArray, int[] secondArray) throws RuntimeException {
        if (firstArray == null || secondArray == null) {
            throw new RuntimeException("Один из массивов равен null!");
        }

        if (firstArray.length != secondArray.length) {
            throw new RuntimeException("Массивы разной длины!");
        }

        for (int i = 0; i < secondArray.length; i++) {
            if (secondArray[i] == 0){
                throw new RuntimeException("Один из делителей равен нулю. На ноль делить нельзя!");
            }
        }

        int[] quotient = new int[firstArray.length];

        for (int i = 0; i < firstArray.length; i++){
            quotient[i] = firstArray[i] / secondArray[i];
        }

        return quotient;
    }
}
