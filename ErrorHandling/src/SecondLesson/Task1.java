package SecondLesson;

import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 * и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static float readFloat() {
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input float number");
            var userString = scanner.nextLine();
            try {
                if (userString != null) {
                    return Float.parseFloat(userString);
                }
            } catch (NumberFormatException ex) {
                System.err.println("This is not number");
            }
        }
    }
}
