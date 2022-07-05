import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    //Initialize the list for the student pin
    private static List<StudentPin> studentPinList = new ArrayList<>();
    //Initialize scanner to get user inputs
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Loop continuously until user selects to exit the program
        while (true) {
            //Show menu
            System.out.println("\nSelect an option below:");
            System.out.println("1. Add Student Pin");
            System.out.println("2. Login via ID and Pin");
            System.out.println("3. Exit Program");

            //Prompt user to enter an option
            System.out.print("\nEnter no. of option here: ");
            //Get option input
            String option = scanner.nextLine();
            
            //Check option
            switch (option) {
                case "1":
                    addStudentPin();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }

    //This is the add student pin method
    private static void addStudentPin() {
        //Loop continuously until user prompt no to add another student
        while (true) {
            //Prompt to enter student id
            System.out.print("Enter student id: ");
            //Get the student id
            String id = scanner.nextLine();

            //Prompt to enter pin
            System.out.print("Enter pin: ");
            //Get the student pin
            String pin = scanner.nextLine();

            //Create the StudentPin object
            StudentPin studentPin = new StudentPin(id, pin);
            //Add the StudentPin object to the list
            studentPinList.add(studentPin);

            //Prompt to add another pin or exit
            System.out.print("Successfully added student pin. Add another? Enter Y for yes, and N for No: ");

            //Get the user confirmation
            String answer = scanner.nextLine();

            //If user answer is not equal to Y or yes, then end loop by using break
            //otherwise just loop again to add another pin
            if (!answer.equalsIgnoreCase("Y")) {
                break;
            }
        }

        //After add student pins, display the records in the list
        displayStudentPin();
    }

    //This is the display student pin method, which displays the student pin list
    private static void displayStudentPin() {
        System.out.println("\nDisplaying Student Pin Information\n");

        //Create a format to display the values. Use 20 spacings and right justify them using %-20s
        String format = "| %-20s | %-20s |";
        System.out.printf(format, "ID", "Pin");
        System.out.println();

        for (StudentPin studentPin : studentPinList) {
            System.out.printf(format, studentPin.getId(), studentPin.getPin());
            System.out.println();
        }
    }

    //This is the login method, which allows the user to enter a pin and id to attempt a login
    private static void login() {
        System.out.println("Enter student id to login: ");
        String id = scanner.nextLine();

        System.out.println("Enter pin: ");
        String pin = scanner.nextLine();

        boolean isSuccessful = false;

        for (StudentPin studentPin : studentPinList) {
            if (studentPin.getPin().equals(pin) && studentPin.getId().equals(id)) {
                System.out.println("Successful login of id and pin.");
                isSuccessful = true;
            }
        }

        if (!isSuccessful) {
            System.out.println("No id and pin match for login. Try again.");
        }
    }
}
