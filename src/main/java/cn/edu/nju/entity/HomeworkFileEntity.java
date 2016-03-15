package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/13.
 */
@Entity
@Table(name = "homework_file", schema = "tss", catalog = "")
public class HomeworkFileEntity {
    private int fid;
    private String fname;

    @Id
    @Column(name = "fid")
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeworkFileEntity that = (HomeworkFileEntity) o;

        if (fid != that.fid) return false;
        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fid;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        return result;
    }
}
