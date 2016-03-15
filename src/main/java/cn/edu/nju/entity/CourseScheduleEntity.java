package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by lance on 2/15/16.
 */
@Entity
@Table(name = "course_schedule", schema = "tss", catalog = "")
public class CourseScheduleEntity {
    private int csid;
    private String cid;
    private String tid;
    private String term;

    @Id
    @Column(name = "csid", nullable = false, insertable = true, updatable = true)
    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    @Basic
    @Column(name = "cid", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "tid", nullable = true, insertable = true, updatable = true, length = 10)
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "term", nullable = false, insertable = true, updatable = true, length = 15)
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseScheduleEntity that = (CourseScheduleEntity) o;

        if (csid != that.csid) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (term != null ? !term.equals(that.term) : that.term != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = csid;
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        return result;
    }
}
