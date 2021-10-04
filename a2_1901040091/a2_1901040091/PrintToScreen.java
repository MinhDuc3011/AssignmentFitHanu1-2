package a2_1901040091;

public class PrintToScreen {
    public static void main(String[] args) {
        Student Duc = new Student("1", "Duc");
        Course SAD = new Course("802", "SAD");
        Enrollment Newbie = new Enrollment(Duc, SAD, 10, 9, 8);
        System.out.println("Student " + Newbie.student.studentName
                                      + "ID: " + Newbie.student.studentId
                                      + "Attendance mark: " + Newbie.attendanceMark
                                      + "Mid mark: " + Newbie.midtermMark
                                      + "Final mark: " + Newbie.finalMark
                                      + "overall" + Newbie.overall());
    }
}
