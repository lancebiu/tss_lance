package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/13.
 */
@Entity
@Table(name = "homework", schema = "tss", catalog = "")
public class HomeworkEntity {
    private int hid;
    private int csid;
    private String deadline;
    private String description;
    private Integer efid;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeworkEntity that = (HomeworkEntity) o;

        if (hid != that.hid) return false;
        if (csid != that.csid) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (efid != null ? !efid.equals(that.efid) : that.efid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hid;
        result = 31 * result + csid;
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (efid != null ? efid.hashCode() : 0);
        return result;
    }
}
