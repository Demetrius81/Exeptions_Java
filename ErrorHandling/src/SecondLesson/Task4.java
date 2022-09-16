package SecondLesson;

import java.util.Scanner;

/**
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя
 */
public class Task4 {
    public static String readString() throws Exception {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input the string");

            String userString = scanner.nextLine();

            if (userString.isEmpty()) {
                throw new Exception("String can not be empty");
            }
            return userString;
        }
    }
}
