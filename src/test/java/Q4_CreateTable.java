import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q4_CreateTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "Buraya kendi sifrenizi yazacaksiniz.");

        //3) Statement: SQL kodlarimizi yazmak için bir nesne oluştur
        Statement st = con.createStatement();

        List<Q4_Student> state2=new ArrayList<>();
        state2.add(new Q4_Student("Student A",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student A",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student A",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student B",new Q4_Course("Course Y")));
        state2.add(new Q4_Student("Student B",new Q4_Course("Course Y")));
        state2.add(new Q4_Student("Student C",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student C",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student D",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student E",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student E",new Q4_Course("Course X")));
        state2.add(new Q4_Student("Student E",new Q4_Course("Course X")));
        PreparedStatement state2Table = con.prepareStatement("insert into state2 values(?,?)");
        for (Q4_Student each : state2) {
            state2Table.setObject(1, each.getStudent());
            state2Table.setObject(2, each.getCourse());
            state2Table.addBatch();
        }
        state2Table.executeBatch();
        System.out.println("Veriler Database'e eklendi");
        //4) ResultSet:
        ResultSet state2Data = st.executeQuery("select * from state2");
        while (state2Data.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", state2Data.getInt(1), state2Data.getString(2));
        }
        ResultSet stateData = st.executeQuery("SELECT student, course FROM state2 GROUP BY student, course" +
                "HAVING (COUNT(student) = 1) AND (COUNT(course) = 1) ;");

        while (stateData.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", stateData.getInt(1), stateData.getString(2));
        }


    }
}
