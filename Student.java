import java.util.*;

public class Student extends Class {

    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Student() {

    }

    // display class
    public void displayClass() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("...This is Student View...");
    }

    // add student
    public void addStudent(String username, String password) {
        this.Student.put(username, password);
    }

    // get password
    public String getPassword(String name) {
        Enumeration names;
        String str;
        names = this.Student.keys();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (names.hasMoreElements()) {
            str = (String) names.nextElement();
            if (str.equalsIgnoreCase(name)) {
                return (String) this.Student.get(str);
            }
        }
        return " ";
    }

    public int printMarks() {
        System.out.println("Type in your id: ");
        int id = -1;
        int marks = 0;
        id = scanner.nextInt();
        if (id >= 0 && id <= 30) {
            marks = this.Marks[id - 1];
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Your marks are: " + marks);
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\nNot submitted valid id");
        }

        return marks;
    }
}
