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
public class TrangThaiChoDat implements Serializable {
    @Id
    @Column(name = "MaTrangThai", nullable = false, length = 10)
    private String maTrangThai;
    @Basic
    @Column(name = "TrangThai", nullable = false, length = 10)
    private String trangThai;
    @ManyToOne
    @JoinColumn(name = "MaLichTrinh", referencedColumnName = "MaLichTrinh", nullable = false)
    private LichTrinh lichTrinhByMaLichTrinh;
    @ManyToOne
    @JoinColumn(name = "MaChoDat",referencedColumnName = "MaChoDat",nullable = false)
    private ChoDat choDatByMaChoDat;
    public TrangThaiChoDat() {

    }

    public TrangThaiChoDat(String maTrangThai, String trangThai, LichTrinh lichTrinhByMaLichTrinh, ChoDat choDatByMaChoDat) {
        this.maTrangThai = maTrangThai;
        this.trangThai = trangThai;
        this.lichTrinhByMaLichTrinh = lichTrinhByMaLichTrinh;
        this.choDatByMaChoDat = choDatByMaChoDat;
    }

    public String getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(String maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public LichTrinh getLichTrinhByMaLichTrinh() {
        return lichTrinhByMaLichTrinh;
    }

    public void setLichTrinhByMaLichTrinh(LichTrinh lichTrinhByMaLichTrinh) {
        this.lichTrinhByMaLichTrinh = lichTrinhByMaLichTrinh;
    }

    public ChoDat getChoDatByMaChoDat() {
        return choDatByMaChoDat;
    }

    public void setChoDatByMaChoDat(ChoDat choDatByMaChoDat) {
        this.choDatByMaChoDat = choDatByMaChoDat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrangThaiChoDat)) return false;
        TrangThaiChoDat that = (TrangThaiChoDat) o;
        return Objects.equals(getMaTrangThai(), that.getMaTrangThai()) && Objects.equals(getTrangThai(), that.getTrangThai()) && Objects.equals(getLichTrinhByMaLichTrinh(), that.getLichTrinhByMaLichTrinh()) && Objects.equals(getChoDatByMaChoDat(), that.getChoDatByMaChoDat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaTrangThai(), getTrangThai(), getLichTrinhByMaLichTrinh(), getChoDatByMaChoDat());
    }

}
