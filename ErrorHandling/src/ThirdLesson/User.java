package ThirdLesson;

/**
 * Модель пользователя.
 */
public class User {
    /**
     * Имя.
     */
    private String firstName;
    /**
     * Фамилия.
     */
    private String lastName;
    /**
     * Отчество.
     */
    private String middleName;
    /**
     * Дата рождения.
     */
    private String dateOfBirth;
    /**
     * Номер телефона.
     */
    private int phoneNumber;
    /**
     * Пол.
     */
    private String sex;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(String user) throws BadDataException {
        user.replace("><", " ");
        user.replace('<', ' ');
        user.replace('>', ' ');
        user.trim();
        String[] userArr = user.split(" ");
        if (userArr.length != 6) {
            throw new BadDataException("Не совпадает количество введенных данных");
        }
        lastName = userArr[0];
        firstName = userArr[1];
        middleName = userArr[2];
        dateOfBirth = userArr[3];
        try {
            phoneNumber = Integer.parseInt(userArr[4]);
        } catch (NumberFormatException ex){
            throw new BadDataException("Неверный формат телефонного номера");
        }
        sex = userArr[5];


    }

    @Override
    public String toString() {
        return '<' + firstName + '>' +
                '<' + lastName + '>' +
                '<' + middleName + '>' +
                '<' + dateOfBirth + '>' +
                '<' + phoneNumber + '>' +
                '<' + sex + '>';
    }
}
