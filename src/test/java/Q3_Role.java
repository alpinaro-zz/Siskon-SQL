public class Q3_Role {
    private String roleName;
    private int roleID;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Q3_Role( int roleID,String roleName) {
        this.roleName = roleName;
        this.roleID = roleID;
    }
    public Q3_Role( int roleID) {
        this.roleID = roleID;
    }


    @Override
    public String toString() {
        return "Q3_User{" +
                "roleName='" + roleName + '\'' +
                ", roleID=" + roleID +
                '}';
    }
}
