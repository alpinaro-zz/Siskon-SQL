import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreateCustomerOperation {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "Buraya kendi sifrenizi yazacaksiniz.");

        //3) Statement: SQL kodlarimizi yazmak için bir nesne oluştur
        Statement st = con.createStatement();

        List<CustomerTable> customerList = new ArrayList<>();
        customerList.add(new CustomerTable(1, "Customer A"));
        customerList.add(new CustomerTable(2, "Customer B"));
        customerList.add(new CustomerTable(3, "Customer C"));
        PreparedStatement customerTable = con.prepareStatement("insert into coursesTable values(?,?)");
        for (CustomerTable each : customerList) {
            customerTable.setObject(1, each.getCustomerID());
            customerTable.setObject(2, each.getCustomerName());
            customerTable.addBatch();
        }
        customerTable.executeBatch();
        System.out.println("Veriler Database'e eklendi");
        //4) ResultSet:
        ResultSet customerData = st.executeQuery("select * from customerTable");
        while (customerData.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", customerData.getInt(1), customerData.getString(2));
        }
        //created costumerOperation table
        PreparedStatement custOpTable = con.prepareStatement("insert into customerOperationTable values(?,?,?,?)");
        List<CustomerOperation> custOpList = new ArrayList<>();
        custOpList.add(new CustomerOperation(new CustomerTable(1), 1000, "2010-01-24"));
        custOpList.add(new CustomerOperation(new CustomerTable(1), 2300, "2010-03-26"));
        custOpList.add(new CustomerOperation(new CustomerTable(1), 300, "2010-05-18"));
        custOpList.add(new CustomerOperation(new CustomerTable(1), 12000, "2011-03-28"));
        custOpList.add(new CustomerOperation(new CustomerTable(1), 4000, "2011-07-05"));
        custOpList.add(new CustomerOperation(new CustomerTable(1), 7500, "2012-01-03"));
        custOpList.add(new CustomerOperation(new CustomerTable(2), 4000, "2010-01-24"));
        custOpList.add(new CustomerOperation(new CustomerTable(2), 5000, "2010-03-26"));
        custOpList.add(new CustomerOperation(new CustomerTable(2), 1000, "2010-05-18"));
        custOpList.add(new CustomerOperation(new CustomerTable(2), 2400, "2011-03-28"));
        custOpList.add(new CustomerOperation(new CustomerTable(2), 500, "2011-07-05"));
        custOpList.add(new CustomerOperation(new CustomerTable(2), 3000, "2012-01-03"));
        custOpList.add(new CustomerOperation(new CustomerTable(3), 3200, "2010-01-24"));
        custOpList.add(new CustomerOperation(new CustomerTable(3), 300, "2012-05-03"));
        int i = 1;
        for (CustomerOperation each : custOpList) {
            custOpTable.setObject(1, i);
            custOpTable.setObject(2, each.getCustomerId());
            custOpTable.setObject(3, each.getTotalAmount());
            custOpTable.setObject(4, each.getEventDate());
            i++;
            custOpTable.addBatch();
        }
        custOpTable.executeBatch();
        System.out.println("Veriler Database'e eklendi");
        //4) ResultSet:
        ResultSet customerOpData = st.executeQuery("select * from customerOperationTable");
        while (customerOpData.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", customerOpData.getObject(1), customerOpData.getString(2),
                    customerOpData.getObject(3), customerOpData.getObject(4));
        }

        // find the avarage TotalAmount for last 3 values for each Customer
        ResultSet atLeastThree = st.executeQuery("with customerOperationTable as (\n" +
                "         SELECT  \n" +
                "             customerID, totalAmount, row_number() over(partition by customerID order by evetDate desc) rn\n" +
                "         from \n" +
                "             customerOperationTable\n" +
                "     )\n" +
                "     select customerID, avg(value)\n" +
                "     from customerOperationTable\n" +
                "     where rn<=3\n" +
                "     group by customerID");

        while (atLeastThree.next()) {

            System.out.printf("%-6d %-15.15s %-8s %-8s\n", atLeastThree.getInt(1));

        }
    }
}
