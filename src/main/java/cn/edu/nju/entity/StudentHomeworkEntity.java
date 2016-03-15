package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/13.
 */
@Entity
@Table(name = "student_homework", schema = "tss", catalog = "")
public class StudentHomeworkEntity {
    private int shid;
    private int hid;
    private String uid;
    private Integer fid;
    private String score;
    private Integer status;

    @Id
    @Column(name = "shid")
    public int getShid() {
        return shid;
    }

    public void setShid(int shid) {
        this.shid = shid;
    }

    @Basic
    @Column(name = "hid")
    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
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
    @Column(name = "fid")
    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "score")
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHomeworkEntity that = (StudentHomeworkEntity) o;

        if (shid != that.shid) return false;
        if (hid != that.hid) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (fid != null ? !fid.equals(that.fid) : that.fid != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shid;
        result = 31 * result + hid;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (fid != null ? fid.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
