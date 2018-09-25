package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;


import java.io.Serializable;

public class Role implements Serializable{
    private static final long serialVersionUID=-3334024283822942732L;
    private String roleName;

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
