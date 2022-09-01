import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Q3_CreateTable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "Buraya kendi sifrenizi yazacaksiniz.");

        //3) Statement: SQL kodlarimizi yazmak için bir nesne oluştur
        Statement st = con.createStatement();
        List<Q3_Role> roleList=new ArrayList<>();
        roleList.add(new Q3_Role(1,"Role A"));
        roleList.add(new Q3_Role(2,"Role B"));
        roleList.add(new Q3_Role(3,"Role C"));
        roleList.add(new Q3_Role(4,"Role D"));
        roleList.add(new Q3_Role(5,"Role E"));
        PreparedStatement roleTable = con.prepareStatement("insert into roleTable values(?,?)");
        for (Q3_Role each : roleList) {
            roleTable.setObject(1, each.getRoleID());
            roleTable.setObject(2, each.getRoleName());
            roleTable.addBatch();
        }
        roleTable.executeBatch();
        System.out.println("Veriler Database'e eklendi");
        //4) ResultSet:
        ResultSet roleDATA = st.executeQuery("select * from roleTable");
        while (roleDATA.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", roleDATA.getInt(1), roleDATA.getString(2));
        }

        //user table
        List<Q3_User> userList=new ArrayList<>();
        userList.add(new Q3_User(1,"Role A"));
        userList.add(new Q3_User(2,"Role B"));
        userList.add(new Q3_User(3,"Role C"));
        userList.add(new Q3_User(4,"Role D"));
        userList.add(new Q3_User(5,"Role E"));
        PreparedStatement userTable = con.prepareStatement("insert into userTable values(?,?)");
        for (Q3_User each : userList) {
            userTable.setObject(1, each.getUserID());
            userTable.setObject(2, each.getUserName());
            userTable.addBatch();
        }
        userTable.executeBatch();
        System.out.println("Veriler Database'e eklendi");
        //4) ResultSet:
        ResultSet userDATA = st.executeQuery("select * from userTable");
        while (userDATA.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", userDATA.getInt(1), userDATA.getString(2));
        }
        //Parent Role
        // PREPAREDSTATEMENT: ifadeler parametrre kullanilarak yollanabilir.
        String [] parentRole = {"insert into parent values (1,2)",
                "insert into parent values (1,2)",
                "insert into parent values (1,2)",
                "insert into parent values (1,2)",
                "insert into parent values (1,2)"};

        for (String each:parentRole){
            st.addBatch(each);
        }
        st.executeBatch();

        //UserRoleAssignment
        //user table
        List<Q3_RoleAssignment> userRoleAssignList=new ArrayList<>();
        userRoleAssignList.add(new Q3_RoleAssignment(new Q3_User(1),new Q3_Role(2)));
        userRoleAssignList.add(new Q3_RoleAssignment(new Q3_User(1),new Q3_Role(3)));
        userRoleAssignList.add(new Q3_RoleAssignment(new Q3_User(2),new Q3_Role(4)));
        userRoleAssignList.add(new Q3_RoleAssignment(new Q3_User(2),new Q3_Role(5)));
        PreparedStatement userRoleAssignTable = con.prepareStatement("insert into userRoleAssignTable values(?,?)");
        for (Q3_RoleAssignment each : userRoleAssignList) {
            userRoleAssignTable.setObject(1, each.getUserID());
            userRoleAssignTable.setObject(2, each.getRoleID());
            userRoleAssignTable.addBatch();
        }
        userRoleAssignTable.executeBatch();
        System.out.println("Veriler Database'e eklendi");
        //4) ResultSet:
        ResultSet roleAssignDATA = st.executeQuery("select * from userTable");
        while (roleAssignDATA.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", roleAssignDATA.getInt(1), roleAssignDATA.getString(2));
        }



    }
}
