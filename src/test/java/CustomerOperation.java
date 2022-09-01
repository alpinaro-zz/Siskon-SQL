public class CustomerOperation {
 private  int   totalAmount;
 private String eventDate;
 private CustomerTable customerId;

    public CustomerTable getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerTable customerId) {
        this.customerId = customerId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public CustomerOperation(CustomerTable CustomerId, int totalAmount, String eventDate) {
        this.totalAmount = totalAmount;
        this.eventDate = eventDate;
        this.customerId=CustomerId;
    }

    @Override
    public String toString() {
        return "CustomerOperation{" +
                "totalAmount=" + totalAmount +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}
