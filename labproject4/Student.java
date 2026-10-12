
package labproject4;


public class Student {
    private String studentID;
    private String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }
    
    public void studentInfo(){
        System.out.printf("Name: %s\nID: %s\n",name,studentID);
    }
    
}
