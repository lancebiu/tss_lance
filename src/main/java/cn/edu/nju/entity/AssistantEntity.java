package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/12.
 */
@Entity
@Table(name = "assistant", schema = "tss", catalog = "")
public class AssistantEntity {
    private int aid;
    private String uid;
    private int csid;

    @Id
    @Column(name = "aid")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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
    @Column(name = "csid")
    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssistantEntity that = (AssistantEntity) o;

        if (aid != that.aid) return false;
        if (csid != that.csid) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + csid;
        return result;
    }
}
