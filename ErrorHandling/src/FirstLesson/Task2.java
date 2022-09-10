package FirstLesson;

/**
 * Задача 2.
 * Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
 */
public class Task2 {
    /**
     * Перехвачены все возможные исключения (на мой взгляд)
     */
    public static void testTask(){
        int sum = 0;

        try{
            //sum = Task2.sum2d(new String[][]{{"1", "2"},{"3", "2"}});
            //sum = Task2.sum2d(new String[][]{{"rt", "2"},{"3", "2"}});
            //sum = Task2.sum2d(null);
            sum = Task2.sum2d(new String[][]{
                    {"1", "1", "1", "1", "1"},
                    {"1", "1", "1", "1", "1"},
                    {"1", "1", "1", "1", "1"},
                    {"1", "1", "1", "1", "1"},
                    {"1", "1", "1", "1", "1"}});
        }
        catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
        }
        catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println(sum);
    }

    /**
     * Исследуемый метод
     * @param arr матрица строк
     * @return целое число
     */
    private static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
}
