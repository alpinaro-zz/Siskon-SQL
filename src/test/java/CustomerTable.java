public class CustomerTable {
   private   int customerID;
   private String CustomerName;

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public CustomerTable(int customerID, String customerName) {
        this.customerID = customerID;
        CustomerName = customerName;
    }

    public CustomerTable(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "CustomerTable{" +
                "customerID=" + customerID +
                ", CustomerName='" + CustomerName + '\'' +
                '}';
    }
}
