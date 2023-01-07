public class Dispatcher {
    
    private Instructor instructor;
    private Student student;

    //Constructor
    public Dispatcher(){
        instructor=new Instructor();
        student=new Student();
    }

    public void dispatch(String request, int functionToExecute){
        if(request.equalsIgnoreCase("Instructor")){
            if(functionToExecute==1){
                instructor.addMarksInitially(30);
            }
            else if(functionToExecute==2){
                instructor.updateMarksWithID();
            }
            else if(functionToExecute==3){
                instructor.printMarks();
            }
            else if(functionToExecute==4){
                instructor.getAverage();
            }
            else if(functionToExecute==5){
                instructor.getTotalMarks();
            }
            else if(functionToExecute==6){
                instructor.getMarksOfStudent();
            }
        }
        else if(request.equalsIgnoreCase("Student")){
            if(functionToExecute==1){
                student.printMarks();
            }
            else if(functionToExecute==2){
                student.getAverage();
            }
        }
    }
}
