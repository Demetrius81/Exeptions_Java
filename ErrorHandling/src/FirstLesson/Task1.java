package FirstLesson;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 1
 */
public class Task1 {
    /**
     * Генерация ArrayIndexOutOfBoundsException
     */
    public static void firstException() {

        var arr = new int[]{};

        System.out.println(arr[18]);
    }

    /**
     * Генерация StackOverflowError
     */
    public static void secondException() {

        System.out.println("Hello, Exception!");

        secondException();
    }

    /**
     * Генерация OutOfMemoryError
     */
    public static void thirdException() {

        List<TestObject> objects = new ArrayList<>();
        while (true) {
            objects.add(new TestObject());
        }
    }
}
