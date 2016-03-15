package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/13.
 */
@Entity
@Table(name = "complete_selected_course", schema = "tss", catalog = "")
public class CompleteSelectedCourseEntity {
    private int csid;
    private String cid;
    private String tid;
    private String term;
    private String cname;
    private int credit;
    private String tname;
    private String uid;
    private String uname;
    private int id;

    @Basic
    @Column(name = "csid")
    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    @Basic
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "tid")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "term")
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "credit")
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "tname")
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompleteSelectedCourseEntity that = (CompleteSelectedCourseEntity) o;

        if (csid != that.csid) return false;
        if (credit != that.credit) return false;
        if (id != that.id) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (term != null ? !term.equals(that.term) : that.term != null) return false;
        if (cname != null ? !cname.equals(that.cname) : that.cname != null) return false;
        if (tname != null ? !tname.equals(that.tname) : that.tname != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = csid;
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + credit;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
