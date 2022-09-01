import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "Buraya kendi sifrenizi yazacaksiniz.");

        List<CourseID> courses=new ArrayList<>();
        courses.add(new CourseID("MAT3"));
        courses.add(new CourseID("SOS1"));
        courses.add(new CourseID("FEN2"));
        List<CourseStudentTable> studentTables=new ArrayList<>();
        studentTables.add(new CourseStudentTable(new CourseID("MAT3"),"Mehmet"));
        studentTables.add(new CourseStudentTable(new CourseID("SOS1"),"Ahmet"));
        studentTables.add(new CourseStudentTable(new CourseID("MAT3"),"Ahmet"));
        studentTables.add(new CourseStudentTable(new CourseID("FEN2"),"Ahmet"));
        studentTables.add(new CourseStudentTable(new CourseID("SOS1"),"Ali"));
        studentTables.add(new CourseStudentTable(new CourseID("FEN2"),"Ayse"));

        PreparedStatement tabloCourse = con.prepareStatement("insert into urunler values(?)");
        for(CourseID each:courses){
            tabloCourse.setString(1, each.getCourse1());
            tabloCourse.addBatch();
        }
        tabloCourse.executeBatch();
        //created course table
        System.out.println("Veriler Database'e eklendi");


        //creating CourseStudentTable
        PreparedStatement tableStudentCourses = con.prepareStatement("insert into urunler values(?, ?)");
        for(CourseStudentTable each:studentTables){
            tableStudentCourses.setObject(1, each.getCourseID());
            tableStudentCourses.setString(2, each.getStudent());
            tableStudentCourses.addBatch();
        }
        tableStudentCourses.executeBatch();
        System.out.println("Veriler Database'e eklendi");








    }
}
