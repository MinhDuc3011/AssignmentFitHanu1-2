package a2_1901040091;

public class Student {
     String studentId;
     String studentName;
    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public void SetName(String newName) {
        this.studentName = newName;
    } 
    public void SetId(String newId) {
        this.studentId = newId;
    }
    public String GetName () {
        return studentName;
    }
    public String GetId () {
        return studentId;
    }
}
