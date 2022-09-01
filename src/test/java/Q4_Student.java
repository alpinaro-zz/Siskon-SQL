public class Q4_Student {


    private  String student;
    private Q4_Course course;

    public Q4_Course getCourse() {
        return course;
    }

    public void setCourse(Q4_Course course) {
        this.course = course;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Q4_Student(String student,Q4_Course course) {
        this.student = student;
        this.course=course;
    }

    @Override
    public String toString() {
        return "Q4_Student{" +
                "student='" + student + '\'' +
                '}';
    }
}
