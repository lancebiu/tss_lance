package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by lance on 2/15/16.
 */
@Entity
@Table(name = "teacher", schema = "", catalog = "tss")
public class TeacherEntity {
    private String tid;
    private String password;
    private String tname;
    private String department;

    @Id
    @Column(name = "tid", nullable = false, insertable = true, updatable = true, length = 10)
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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
    @Column(name = "tname", nullable = false, insertable = true, updatable = true, length = 10)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

        TeacherEntity that = (TeacherEntity) o;

        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (tname != null ? !tname.equals(that.tname) : that.tname != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }
}
