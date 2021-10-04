package a2_1901040091;

public class Course {
    private String courseCode;
    private String courseName;
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    public void SetCode(String newCode) {
        this.courseCode = newCode;
    }
    public void SetName(String newName) {
        this.courseName = newName;
    }
    public String GetCode() {
        return courseCode;
    }
    public String GetName() {
        return courseName;
    }
    
}
