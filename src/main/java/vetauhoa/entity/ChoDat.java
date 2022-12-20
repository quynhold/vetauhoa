package vetauhoa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class ChoDat implements Serializable {
    @Id
    @Column(name = "MaChoDat", nullable = false, length = 4)
    private String maChoDat;
    @Basic
    @Column(name = "SoThuTu", nullable = false)
    private int soThuTu;
    @ManyToOne
    @JoinColumn(name = "MaToa", referencedColumnName = "MaToa", nullable = false)
    private Toa toaByMaToa;
    @OneToMany(mappedBy = "choDatByMaChoDat")
    private Collection<PhieuDat> phieuDatsByMaChoDat;
    @OneToMany(mappedBy = "choDatByMaChoDat")
    private Collection<TrangThaiChoDat> trangThaiChoDatsByMaChoDat;
    public ChoDat() {

    }


    public String getMaChoDat() {
        return this.maChoDat;
    }
    public void setMaChoDat(String maChoDat) {
        this.maChoDat = maChoDat;
    }


    public int getSoThuTu() {
        return soThuTu;
    }
    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public Toa getToaByMaToa() {
        return toaByMaToa;
    }
    public void setToaByMaToa(Toa toaByMaToa) {
        this.toaByMaToa = toaByMaToa;
    }

    public Collection<PhieuDat> getPhieuDatsByMaChoDat() {
        return phieuDatsByMaChoDat;
    }
    public void setPhieuDatsByMaChoDat(Collection<PhieuDat> phieuDatsByMaChoDat) {
        this.phieuDatsByMaChoDat = phieuDatsByMaChoDat;
    }

    public ChoDat(String maChoDat, int soThuTu, Toa toaByMaToa, Collection<PhieuDat> phieuDatsByMaChoDat, Collection<TrangThaiChoDat> trangThaiChoDatsByMaChoDat) {
        this.maChoDat = maChoDat;
        this.soThuTu = soThuTu;
        this.toaByMaToa = toaByMaToa;
        this.phieuDatsByMaChoDat = phieuDatsByMaChoDat;
        this.trangThaiChoDatsByMaChoDat = trangThaiChoDatsByMaChoDat;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ChoDat)) return false;
//        ChoDat choDat = (ChoDat) o;
//        return getSoThuTu() == choDat.getSoThuTu() && getMaChoDat().equals(choDat.getMaChoDat()) && getToaByMaToa().equals(choDat.getToaByMaToa()) && getPhieuDatsByMaChoDat().equals(choDat.getPhieuDatsByMaChoDat()) && getTrangThaiChoDatsByMaChoDat().equals(choDat.getTrangThaiChoDatsByMaChoDat());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getMaChoDat(), getSoThuTu(), getToaByMaToa(), getPhieuDatsByMaChoDat(), getTrangThaiChoDatsByMaChoDat());
//    }

    public Collection<TrangThaiChoDat> getTrangThaiChoDatsByMaChoDat() {
        return trangThaiChoDatsByMaChoDat;
    }

    public void setTrangThaiChoDatsByMaChoDat(Collection<TrangThaiChoDat> trangThaiChoDatsByMaChoDat) {
        this.trangThaiChoDatsByMaChoDat = trangThaiChoDatsByMaChoDat;
    }
}
