
public class CourseStudentTable {
   private CourseID courseID;
    private String Student;

    public void setStudent(String student) {
        Student = student;
    }

    public String getStudent() {
        return Student;
    }

    public CourseID getCourseID() {
        return courseID;
    }

    public void setCourseID(CourseID courseID) {
        this.courseID = courseID;
    }

    public CourseStudentTable(CourseID courseID, String student) {
        this.courseID = courseID;
        Student = student;
    }

    @Override
    public String toString() {
        return "CourseStudentTable{" +
                "courseID=" + courseID +
                ", Student='" + Student + '\'' +
                '}';
    }
}
