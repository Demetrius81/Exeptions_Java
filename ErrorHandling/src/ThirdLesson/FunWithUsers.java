package ThirdLesson;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
 * разделенные пробелом:
 * Фамилия Имя Отчество, дата рождения, номер телефона, пол
 * Форматы данных: фамилия, имя, отчество - строки
 * дата рождения - строка формата dd.mm.yyyy
 * номер телефона - целое беззнаковое число без форматирования. Например 71112223344
 * пол - символ латиницей f или m.
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
 * ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы
 * данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы
 * java или создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией,
 * что именно неверно.
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
 * записаться полученные данные, вида:
 * <Фамилия><Имя><Отчество><дата рождения> <номер телефона><пол>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
public class FunWithUsers {
    public void run() {
        boolean run = true;
        String request;
        String userString;
        var scanner = new Scanner(System.in);
        while (run) {

            System.out.print("""
                    Вас приветствует приложение регистрации пользователей.
                    Для записи пользователя в файл\t\t\tвведите 1
                    Для вывода пользователя на экран\t\tвведите 2
                    Для завершения работы приложения\t\tвведите 0
                    Ожидаю ввода команды>>>\s""");

            String userChoice = scanner.nextLine();
            switch (userChoice.toUpperCase()) {
                case "1" -> {
                    request = """
                            Введите следующие данные в произвольном порядке, разделенные пробелом:
                            Фамилия Имя Отчество
                            Дата рождения\t\tdd.mm.yyyy
                            Номер телефона\t71112223344
                            Пол\t\t\t\t\tf или m\s
                            """;
                    userString = readUserData(scanner, request);
                    try {
                        User user = createModelFromUserInput(userString);
                        writeToFile(user);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    pressEnter(scanner);
                }
                case "2" -> {
                    request = "Введите фамилию пользователя для вывода информации на экран\n";
                    userString = readUserData(scanner, request);
                    List<User> users = new ArrayList<>();
                    try {
                        users = readFromFile(userString);
                    } catch (BadDataException ex) {
                        System.err.println(ex.getMessage());
                    }
                    printUserData(users);
                    pressEnter(scanner);
                }
                case "0" -> run = false;
                default -> {
                }
            }
        }
    }

    private String readUserData(Scanner scanner, String request) {
        System.out.print(request + "Ожидаю ввода команды>>> ");
        return scanner.nextLine();
    }

    private User createModelFromUserInput(String userLine) throws BadDataException {
        userLine = userLine.trim();
        userLine = userLine.replace("\\s+", " ");
        String[] userLineArr = userLine.split(" ");
        String[] lineArr = new String[6];

        if (userLineArr.length != 6) {
            throw new BadDataException("Некорректный ввод данных.");
        } else {
            for (String str : userLineArr) {
                str = str.trim();

                if (str.contains(".")) {
                    str = str.replace('.', '-');
                }

                Pattern pattern = Pattern.compile("^(\\d{2}-\\d{2}-\\d{4})$");
                Pattern pattern1 = Pattern.compile("^(\\d+)$");
                Matcher matcher = pattern.matcher(str);
                Matcher matcher1 = pattern1.matcher(str);
                if ((str.equals("f") || str.equals("m")) && lineArr[5] == null) {
                    lineArr[5] = str;
                } else if (matcher.find() && lineArr[4] == null) {
                    str = str.replace('-', '.');
                    lineArr[4] = str;
                } else if (matcher1.find() && lineArr[3] == null) {
                    lineArr[3] = str;
                } else if (lineArr[0] == null) {
                    lineArr[0] = str;
                } else if (lineArr[1] == null) {
                    lineArr[1] = str;
                } else if (lineArr[2] == null) {
                    lineArr[2] = str;
                }
            }
        }

        for (String str : lineArr) {
            if (str == null) {
                throw new BadDataException("Некорректно введены данные.");
            }
        }

        User user = new User();

        return user.createModel(lineArr);
    }

    private void printUserData(List<User> users) {
        for (User user :
                users) {
            System.out.println(user.toString());
        }
    }

    private void pressEnter(Scanner scanner) {
        System.out.print("Для продолжения нажмите клавишу Enter.");
        scanner.nextLine();
    }

    private void writeToFile(User user) throws InOutException {
        String fileName = System.getProperty("user.dir") + "\\" + user.getLastName() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            String text = user.toFileString();
            writer.write(text + System.getProperty("line.separator"));
        } catch (IOException ex) {
            throw new InOutException(ex.getMessage());
        }
    }

    private List<User> readFromFile(String fileName) throws BadDataException {
        fileName = System.getProperty("user.dir") + "\\" + fileName + ".txt";
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                User user = new User();
                users.add(user.createModel(line));
                line = reader.readLine();
            }
        } catch (IOException | BadDataException ex) {
            throw new BadDataException(ex.getMessage());
        }
        return users;
    }
}
