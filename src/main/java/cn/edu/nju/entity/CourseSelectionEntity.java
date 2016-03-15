package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/12.
 */
@Entity
@Table(name = "course_selection", schema = "tss", catalog = "")
public class CourseSelectionEntity {
    private int id;
    private int csid;
    private String uid;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "csid", nullable = false, insertable = true, updatable = true)
    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    @Basic
    @Column(name = "uid", nullable = false, insertable = true, updatable = true, length = 10)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSelectionEntity that = (CourseSelectionEntity) o;

        if (id != that.id) return false;
        if (csid != that.csid) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + csid;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        return result;
    }
}
