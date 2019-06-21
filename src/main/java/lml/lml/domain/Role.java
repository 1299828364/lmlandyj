package lml.lml.domain;

public class Role {
    private String roleNo;
    private String roleName;
    private String superRole;
    private String count;

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSuperRole() {
        return superRole;
    }

    public void setSuperRole(String superRole) {
        this.superRole = superRole;
    }
}
