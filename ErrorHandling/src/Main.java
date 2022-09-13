import SecondLesson.Task1;
import SecondLesson.Task2;
import SecondLesson.Task3;
import SecondLesson.Task4;

public class Main {
    public static void main(String[] args) {

        //Task1.firstException();
        //Task1.secondException();
        //Task1.thirdException();

        //Task2.testTask();

        //Task3.testTask();

        //Task4.testTask();

        Task1.readFloat();

        Task2.someCode();

        try {
            Task3.main(null);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        try {
            Task4.readString();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}