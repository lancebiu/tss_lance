package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/13.
 */
@Entity
@Table(name = "des_homework", schema = "tss", catalog = "")
public class DesHomeworkEntity {
    private int hid;
    private int csid;
    private String deadline;
    private String description;
    private Integer efid;
    private String efname;
    private int shid;
    private String uid;
    private Integer fid;
    private String score;
    private Integer status;

    @Basic
    @Column(name = "hid")
    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    @Basic
    @Column(name = "csid")
    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    @Basic
    @Column(name = "deadline")
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "efid")
    public Integer getEfid() {
        return efid;
    }

    public void setEfid(Integer efid) {
        this.efid = efid;
    }

    @Basic
    @Column(name = "efname")
    public String getEfname() {
        return efname;
    }

    public void setEfname(String efname) {
        this.efname = efname;
    }

    @Basic
    @Id
    @Column(name = "shid")
    public int getShid() {
        return shid;
    }

    public void setShid(int shid) {
        this.shid = shid;
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

        DesHomeworkEntity that = (DesHomeworkEntity) o;

        if (hid != that.hid) return false;
        if (csid != that.csid) return false;
        if (shid != that.shid) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (efid != null ? !efid.equals(that.efid) : that.efid != null) return false;
        if (efname != null ? !efname.equals(that.efname) : that.efname != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (fid != null ? !fid.equals(that.fid) : that.fid != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hid;
        result = 31 * result + csid;
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (efid != null ? efid.hashCode() : 0);
        result = 31 * result + (efname != null ? efname.hashCode() : 0);
        result = 31 * result + shid;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (fid != null ? fid.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
