import java.util.Scanner;

public class Main {

    public static int printInstructorDetails() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("All you can execute are the following commands...Type the letter according to the given command and have it execute..!!");
        System.out.println("1) You have to add Marks of your subject of all 30 students");
        System.out.println("2) You have to update Marks of specific student with respect to the student ID");
        System.out.println("3) You can see the marks of the whole class with respect to their ids");
        System.out.println("4) You can Get the average of the whole class");
        System.out.println("5) You can Get total Marks of the whole class");
        System.out.println("6) You can get the Marks of the person with respect to his/her id ");
        System.out.println("\n type: ");
        Scanner scanner = new Scanner(System.in);
        int feature = scanner.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return feature;
    }

    public static int printInstructorDetailsStudent(){
        System.out.println("1) You can get your marks by telling your id");
        System.out.println("2) You can get the average of class");
        System.out.println("\n type: ");
        Scanner scanner = new Scanner(System.in);
        int feature = scanner.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return feature;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";

        // Asking if the user wants sign up
        // or actually he/she has already been registered as student/instructor
        String inputString = "h";
        while (true) {
            System.out.println("From the option below; \n\t\ttype 'l' for LOGIN\n\t\ttype 's' for SIGNUP\n");
            inputString = scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (inputString.equals("s")) {
                break;
            } else if (inputString.equals("l")) {
                break;
            }
        }

        // if he/she wants to sign up 
        Student student = new Student();
        Instructor instructor = new Instructor();
        while (inputString.equals("s")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("***************WELCOME TO SIGN UP PAGE*****************");
            System.out.println("ARE YOU STUDENT OR INSTRUCTOR\n\ntype 'i' for instructor or 's' for student;\n\n");
            String character = scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("***************WELCOME TO SIGN UP PAGE*****************");
            System.out.println("Enter Username: ");
            username = scanner.nextLine();
            System.out.println("Enter Password: ");
            password = scanner.nextLine();
            if (character.equalsIgnoreCase("i")) {
                instructor.addInstructor(username, password);
            } else if (character.equalsIgnoreCase("s")) {
                student.addStudent(username, password);
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Do you want login now or sign up..?? type 'l' for login or 's' for signup\n\n");
            inputString = scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        // if he/she already has been registered previously or just signed up
        if (inputString.equals("l") || inputString.equals("yes")) {
            System.out.println("***************WELCOME TO LOGIN PAGE*****************");
            System.out.println("Enter Username: ");
            username = scanner.nextLine();
            System.out.println("Enter Password: ");
            password = scanner.nextLine();
            System.out.println("Logging in as\ntype 's' for Student\ntype'i' for Instructor\n");
            inputString = scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        FrontController frontController = new FrontController(username, password);
        
        //checking the authenticity
        if (inputString.equalsIgnoreCase("s")){frontController.manualAuthentication(student);}
        else if (inputString.equalsIgnoreCase("i")){frontController.manualAuthentication(instructor);}

        if (inputString.equalsIgnoreCase("s")) {
            
            int againFlag=1;
            while(againFlag==1){

                int feature=printInstructorDetailsStudent();

                frontController.dispatchRequest("Student", student, feature);

                System.out.println("\n\nDo you want more features to execute..??\ntype 1 or 2\n1) yes\n2) no");
                againFlag = scanner.nextInt();
                System.out.print("\033[H\033[2J");
                System.out.flush();

            }

        } else if (inputString.equalsIgnoreCase("i")) {

            int againFlag = 1;

            while (againFlag == 1) {
                // executing functions
                int feature = printInstructorDetails();

                frontController.dispatchRequest("Instructor", instructor, feature);
                
                System.out.println("\n\nDo you want more features to execute..??\ntype 1 or 2\n1) yes\n2) no");
                againFlag = scanner.nextInt();
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
    }
}