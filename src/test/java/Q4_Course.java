public class Q4_Course {
   private String course;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Q4_Course(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Q4_Course{" +
                "course='" + course + '\'' +
                '}';
    }
}
