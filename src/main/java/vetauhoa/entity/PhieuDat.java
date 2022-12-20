package vetauhoa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class PhieuDat implements Serializable {
    @Id
    @Column(name = "MaPhieuDat", nullable = false, length = 10)
    private String maPhieuDat;
//    @Basic
//    @Column(name = "MaHanhKhach", nullable = false, length = 12)
//    private String maHanhKhach;
//    @Basic
//    @Column(name = "MaChoDat", nullable = false, length = 4)
//    private String maChoDat;
//    @Basic
//    @Column(name = "MaLichTrinh", nullable = false, length = 10)
//    private String maLichTrinh;
//    @Basic
//    @Column(name = "MaGaDen", nullable = false, length = 20)
//    private String maGaDen;
//    @Basic
//    @Column(name = "MaHoaDon", nullable = false, length = 20)
//    private String maHoaDon;
    @Basic
    @Column(name = "ThoiGianDat", nullable = false)
    private Timestamp thoiGianDat;
    @ManyToOne
    @JoinColumn(name = "MaHanhKhach", referencedColumnName = "MaHanhKhach", nullable = true)
    private HanhKhach hanhKhachByMaHanhKhach;
    @ManyToOne
    @JoinColumn(name = "MaChoDat", referencedColumnName = "MaChoDat", nullable = false)
    private ChoDat choDatByMaChoDat;
    @ManyToOne
    @JoinColumn(name = "MaLichTrinh", referencedColumnName = "MaLichTrinh", nullable = false)
    private LichTrinh lichTrinhByMaLichTrinh;
    @ManyToOne
    @JoinColumn(name = "MaGaDen", referencedColumnName = "MaGa", nullable = false)
    private Ga gaByMaGaDen;
    @ManyToOne
    @JoinColumn(name = "MaHoaDon", referencedColumnName = "MaHoaDon", nullable = false)
    private HoaDon hoaDonByMaHoaDon;
    @OneToMany(mappedBy = "phieuDatByMaPhieuDat")
    private Collection<Ve> vesByMaPhieuDat;

    public String getMaPhieuDat() {
        return maPhieuDat;
    }

    public void setMaPhieuDat(String maPhieuDat) {
        this.maPhieuDat = maPhieuDat;
    }

    public PhieuDat(String maPhieuDat, Timestamp thoiGianDat, HanhKhach hanhKhachByMaHanhKhach, ChoDat choDatByMaChoDat, LichTrinh lichTrinhByMaLichTrinh, Ga gaByMaGaDen, HoaDon hoaDonByMaHoaDon, Collection<Ve> vesByMaPhieuDat) {
        this.maPhieuDat = maPhieuDat;
        this.thoiGianDat = thoiGianDat;
        this.hanhKhachByMaHanhKhach = hanhKhachByMaHanhKhach;
        this.choDatByMaChoDat = choDatByMaChoDat;
        this.lichTrinhByMaLichTrinh = lichTrinhByMaLichTrinh;
        this.gaByMaGaDen = gaByMaGaDen;
        this.hoaDonByMaHoaDon = hoaDonByMaHoaDon;
        this.vesByMaPhieuDat = vesByMaPhieuDat;
    }

    public PhieuDat(String maPhieuDat, Timestamp thoiGianDat, HanhKhach hanhKhachByMaHanhKhach, ChoDat choDatByMaChoDat, LichTrinh lichTrinhByMaLichTrinh, Ga gaByMaGaDen, HoaDon hoaDonByMaHoaDon) {
        this.maPhieuDat = maPhieuDat;
        this.thoiGianDat = thoiGianDat;
        this.hanhKhachByMaHanhKhach = hanhKhachByMaHanhKhach;
        this.choDatByMaChoDat = choDatByMaChoDat;
        this.lichTrinhByMaLichTrinh = lichTrinhByMaLichTrinh;
        this.gaByMaGaDen = gaByMaGaDen;
        this.hoaDonByMaHoaDon = hoaDonByMaHoaDon;
    }

    public Timestamp getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Timestamp thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public HanhKhach getHanhKhachByMaHanhKhach() {
        return hanhKhachByMaHanhKhach;
    }
    public PhieuDat(){}
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PhieuDat)) return false;
//        PhieuDat phieuDat = (PhieuDat) o;
//        return getMaPhieuDat().equals(phieuDat.getMaPhieuDat()) && getThoiGianDat().equals(phieuDat.getThoiGianDat()) && getHanhKhachByMaHanhKhach().equals(phieuDat.getHanhKhachByMaHanhKhach()) && getChoDatByMaChoDat().equals(phieuDat.getChoDatByMaChoDat()) && getLichTrinhByMaLichTrinh().equals(phieuDat.getLichTrinhByMaLichTrinh()) && getGaByMaGaDen().equals(phieuDat.getGaByMaGaDen()) && getHoaDonByMaHoaDon().equals(phieuDat.getHoaDonByMaHoaDon()) && getVesByMaPhieuDat().equals(phieuDat.getVesByMaPhieuDat());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getMaPhieuDat(), getThoiGianDat(), getHanhKhachByMaHanhKhach(), getChoDatByMaChoDat(), getLichTrinhByMaLichTrinh(), getGaByMaGaDen(), getHoaDonByMaHoaDon(), getVesByMaPhieuDat());
//    }

    public void setHanhKhachByMaHanhKhach(HanhKhach hanhKhachByMaHanhKhach) {
        this.hanhKhachByMaHanhKhach = hanhKhachByMaHanhKhach;
    }

    public ChoDat getChoDatByMaChoDat() {
        return choDatByMaChoDat;
    }

    public void setChoDatByMaChoDat(ChoDat choDatByMaChoDat) {
        this.choDatByMaChoDat = choDatByMaChoDat;
    }

    public LichTrinh getLichTrinhByMaLichTrinh() {
        return lichTrinhByMaLichTrinh;
    }

    public void setLichTrinhByMaLichTrinh(LichTrinh lichTrinhByMaLichTrinh) {
        this.lichTrinhByMaLichTrinh = lichTrinhByMaLichTrinh;
    }

    public Ga getGaByMaGaDen() {
        return gaByMaGaDen;
    }

    public void setGaByMaGaDen(Ga gaByMaGaDen) {
        this.gaByMaGaDen = gaByMaGaDen;
    }

    public HoaDon getHoaDonByMaHoaDon() {
        return hoaDonByMaHoaDon;
    }

    public void setHoaDonByMaHoaDon(HoaDon hoaDonByMaHoaDon) {
        this.hoaDonByMaHoaDon = hoaDonByMaHoaDon;
    }

    public Collection<Ve> getVesByMaPhieuDat() {
        return vesByMaPhieuDat;
    }

    public void setVesByMaPhieuDat(Collection<Ve> vesByMaPhieuDat) {
        this.vesByMaPhieuDat = vesByMaPhieuDat;
    }
}
