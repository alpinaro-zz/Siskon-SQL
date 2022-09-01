public class Q3_RoleAssignment {
  private   Q3_User userID;
  private   Q3_Role roleID;

    public Q3_User getUserID() {
        return userID;
    }

    public void setUserID(Q3_User userID) {
        this.userID = userID;
    }

    public Q3_Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Q3_Role roleID) {
        this.roleID = roleID;
    }

    public Q3_RoleAssignment(Q3_User userID, Q3_Role roleID) {
        this.userID = userID;
        this.roleID = roleID;
    }
}
