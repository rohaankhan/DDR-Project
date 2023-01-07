import java.lang.*;
import java.util.*;
public class FrontController {
    private Dispatcher dispatcher;
    boolean authenticity;
    String username;
    String password;


    //Constructor
    public FrontController(String username, String password){
        dispatcher=new Dispatcher();
        authenticity=false;
        this.username=username;
        this.password=password;
    }
    public FrontController(){
        dispatcher=new Dispatcher();
        authenticity=false;
        this.username="";
        this.password="";
    }

    //Authenticity of User
    public boolean isAuthenticUser(Class student){
        
        if(student.getPassword(this.username).equalsIgnoreCase(this.password)){
            this.authenticity=true;
            return true;
        }
        this.authenticity=false;
        return false;
    }

    //Displaying type of request
    public void trackRequest(String request){
        System.out.print("Request View: "+request+"\n");
    }

    public void dispatchRequest(String request, Class person, int functionToExecute){
        trackRequest(request);
        if(isAuthenticUser(person)){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            dispatcher.dispatch(request,functionToExecute);
        }
    }

    public boolean manualAuthentication(Class person){
        if(isAuthenticUser(person)){
            System.out.println("Authenticated..!!");
            return true;
        }
        else{
            System.out.println("UnAuthenticated..!!");
            System.exit(0);
            return false;
        }
    }
}
