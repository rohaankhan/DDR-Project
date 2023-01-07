
import java.util.*;

public class Instructor extends Class {
    Scanner scanner = new Scanner(System.in);

    // Default contructor
    public Instructor() {

    }

    // display class
    public void displayClass() {
        System.out.println("...This is Instructor View...\n");
    }

    public void addInstructor(String name, String password) {
        this.Instructor.put(name, password);
    }

    public String getPassword(String name) {
        Enumeration names;
        String str;
        names = this.Instructor.keys();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (names.hasMoreElements()) {
            str = (String) names.nextElement();
            if (str.equalsIgnoreCase(name)) {
                return (String) this.Instructor.get(str);
            }
        }
        return " ";
    }

    public void addMarksInitially(int size) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.Student.size());
        for (int i = 0; i < size; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Enter marks with student ID " + (i + 1) + ": ");
            int y = scanner.nextInt();
            this.Marks[i] = y;
        }
    }

    public void updateMarksWithID() {
        System.out.println("What is the id of the person you want to update the marks of: ");
        int id = -1;
        id = scanner.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("What is the new value to update instead of the previous one: ");
        int newMarks = 0;
        newMarks = scanner.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        this.Marks[id - 1] = newMarks;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("The marks with id " + id + " is changed to " + (newMarks));
    }

    // printing the marks with respect to their IDs
    public void printMarks() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("The updated marks of student are as follows: \n");
        for (int i = 0; i < 30; i++) {
            System.out.println("Marks of student with id " + (i + 1) + " are: " + Marks[i]);
        }
    }

    // get total marks of whole class
    public int getTotalMarks() {
        int total = 0;
        for (int i = 0; i < 30; i++) {
            total += Marks[i];
        }
        System.out.print("\033[H\033[2J");
            System.out.flush();
        System.out.println("The total Marks of whole class is: " + total);
        return total;
    }

    // get marks of the person with respect to the person id
    public int getMarksOfStudent() {
        System.out.println("Type in the id of the person you want to get the marks of: ");
        int id = -1;
        int marks = 0;
        id = scanner.nextInt();
        if (id >= 0 && id <= 30) {
            marks = this.Marks[id - 1];
            System.out.println(marks);
        } else {
            System.out.println("\nNot submitted valid id");
        }

        return marks;
    }
}
