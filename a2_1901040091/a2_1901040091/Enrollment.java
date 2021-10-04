package a2_1901040091;

public class Enrollment {
     Student student;
     Course course;
     int attendanceMark;
     float midtermMark;
     float finalMark;

    public Enrollment(Student student, Course course, int attendanceMark, float midtermMark, float finalMark) {
        this.student = student;
        this.course = course;
        this.attendanceMark = attendanceMark;
        this.midtermMark = midtermMark;
        this.finalMark = finalMark;
    }

    public float overall() {
        return (attendanceMark + midtermMark*3 + finalMark*6)/10;
    }
}
