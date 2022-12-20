package vetauhoa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ve implements Serializable {
    @Id
    @Column(name = "MaVe", nullable = false, length = 10)
    private String maVe;

//    @Basic
//    @Column(name = "MaPhieuDat", nullable = false, length = 10)
//    private String maPhieuDat;
    @ManyToOne
    @JoinColumn(name = "MaPhieuDat", referencedColumnName = "MaPhieuDat", nullable = false)
    private PhieuDat phieuDatByMaPhieuDat;

    public Ve(String maVe, PhieuDat phieuDatByMaPhieuDat) {
        this.maVe = maVe;
        this.phieuDatByMaPhieuDat = phieuDatByMaPhieuDat;
    }


    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

//    public String getMaPhieuDat() {
//        return maPhieuDat;
//    }
//
//    public void setMaPhieuDat(String maPhieuDat) {
//        this.maPhieuDat = maPhieuDat;
//    }

    public Ve(){}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ve)) return false;
        Ve ve = (Ve) o;
        return getMaVe().equals(ve.getMaVe()) && getPhieuDatByMaPhieuDat().equals(ve.getPhieuDatByMaPhieuDat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaVe(), getPhieuDatByMaPhieuDat());
    }

    public PhieuDat getPhieuDatByMaPhieuDat() {
        return phieuDatByMaPhieuDat;
    }

    public void setPhieuDatByMaPhieuDat(PhieuDat phieuDatByMaPhieuDat) {
        this.phieuDatByMaPhieuDat = phieuDatByMaPhieuDat;
    }
}
