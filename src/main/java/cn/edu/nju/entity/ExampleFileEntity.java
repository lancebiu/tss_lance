package cn.edu.nju.entity;

import javax.persistence.*;

/**
 * Created by weiyilin on 16/3/13.
 */
@Entity
@Table(name = "example_file", schema = "tss", catalog = "")
public class ExampleFileEntity {
    private int efid;
    private String efname;

    @Id
    @Column(name = "efid")
    public int getEfid() {
        return efid;
    }

    public void setEfid(int efid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleFileEntity that = (ExampleFileEntity) o;

        if (efid != that.efid) return false;
        if (efname != null ? !efname.equals(that.efname) : that.efname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = efid;
        result = 31 * result + (efname != null ? efname.hashCode() : 0);
        return result;
    }
}
