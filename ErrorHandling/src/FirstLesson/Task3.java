package FirstLesson;

/**
 * Задача 3.
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 * каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */
public class Task3 {
    /**
     * Тестирование метода
     */
    public static void testTask() {
        try {
            var arr = arrayDifference(null, new int[]{});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            var arr = arrayDifference(new int[]{3, 4, 5}, new int[]{1, 2, 3});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            var arr = arrayDifference(new int[]{}, new int[]{1, 2, 3});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        try {
            var arr = arrayDifference(new int[]{3, 9, 8}, new int[]{1, 2, 3, 9});

            for(int item : arr){
                System.out.println(item);
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /**
     * Метод вычитания элементов двух равных массивов попарно
     * @param firstArray целочисленный массив - уменьшаемое
     * @param secondArray целочисленный массив - вычитаемое
     * @return целочисленный массив - разность
     */
    private static int[] arrayDifference(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            throw new NullPointerException("Один из массивов равен null!");
        }

        if (firstArray.length != secondArray.length) {
            throw new IllegalArgumentException("Массивы разной длины!");
        }

        int[] difference = new int[firstArray.length];

        for (int i = 0; i < firstArray.length; i++){
            difference[i] = firstArray[i] - secondArray[i];
        }

        return difference;
    }
}
