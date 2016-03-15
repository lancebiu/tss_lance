package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by lance on 2/15/16.
 */
@Entity
@Table(name = "student", schema = "tss", catalog = "")
public class StudentEntity {
    private String uid;
    private String password;
    private String uname;
    private String department;

    @Id
    @Column(name = "uid", nullable = false, insertable = true, updatable = true, length = 10)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "uname", nullable = false, insertable = true, updatable = true, length = 15)
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "department", nullable = false, insertable = true, updatable = true, length = 10)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }
}
