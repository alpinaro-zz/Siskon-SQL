public class Q3_User {
    private String userName;
    private int userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Q3_User( int userID,String userName) {
        this.userName = userName;
        this.userID = userID;
    }
    public Q3_User( ) {
        this.userName = userName;
        this.userID = userID;
    }
    public Q3_User(int userID ) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Q3_User{" +
                "userName='" + userName + '\'' +
                ", userID=" + userID +
                '}';
    }
}
