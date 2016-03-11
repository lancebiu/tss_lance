package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by lance on 2/15/16.
 */
@Entity
@Table(name = "course", schema = "", catalog = "tss")
public class CourseEntity {
    private String cid;
    private String cname;
    private int credit;

    @Id
    @Column(name = "cid", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = false, insertable = true, updatable = true, length = 30)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "credit", nullable = false, insertable = true, updatable = true)
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (credit != that.credit) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (cname != null ? !cname.equals(that.cname) : that.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + credit;
        return result;
    }
}
