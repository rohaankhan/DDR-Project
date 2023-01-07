import java.util.Dictionary;
import java.util.Hashtable;
import java.util.*;

public abstract class Class {
    protected Dictionary Student = new Hashtable();
    protected Dictionary Instructor = new Hashtable();
    protected int Marks[]=new int[30];

    public String getPassword(String username){
        return "";
    }

    // get average of marks of whole class
    public float getAverage() {
        int total = 0;
        for (int i = 0; i < 30; i++) {
            total += Marks[i];
        }
        System.out.println("The average of whole class is :"+total/30);
        return (total / 30);
    }
}
