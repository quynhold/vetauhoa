package vetauhoa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {
    @Id
    @Column(name = "MaHoaDon", nullable = false, length = 20)
    private String maHoaDon;
    @Basic
    @Column(name = "HinhThucThanhToan", nullable = false, length = 20)
    private String hinhThucThanhToan;
    @ManyToOne
    @JoinColumn(name = "MaNhanVien", referencedColumnName = "MaNhanVien", nullable = true)
    private NhanVien nhanVienByMaNhanVien;
    @OneToMany(mappedBy = "hoaDonByMaHoaDon")
    private Collection<PhieuDat> phieuDatsByMaHoaDon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoaDon)) return false;
        HoaDon hoaDon = (HoaDon) o;
        return getMaHoaDon().equals(hoaDon.getMaHoaDon()) && getHinhThucThanhToan().equals(hoaDon.getHinhThucThanhToan()) && getNhanVienByMaNhanVien().equals(hoaDon.getNhanVienByMaNhanVien()) && getPhieuDatsByMaHoaDon().equals(hoaDon.getPhieuDatsByMaHoaDon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaHoaDon(), getHinhThucThanhToan(), getNhanVienByMaNhanVien(), getPhieuDatsByMaHoaDon());
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public NhanVien getNhanVienByMaNhanVien() {
        return nhanVienByMaNhanVien;
    }

    public void setNhanVienByMaNhanVien(NhanVien nhanVienByMaNhanVien) {
        this.nhanVienByMaNhanVien = nhanVienByMaNhanVien;
    }

    public Collection<PhieuDat> getPhieuDatsByMaHoaDon() {
        return phieuDatsByMaHoaDon;
    }

    public void setPhieuDatsByMaHoaDon(Collection<PhieuDat> phieuDatsByMaHoaDon) {
        this.phieuDatsByMaHoaDon = phieuDatsByMaHoaDon;
    }
    public HoaDon(){}

    public HoaDon(String maHoaDon, String hinhThucThanhToan, NhanVien nhanVienByMaNhanVien) {
        this.maHoaDon = maHoaDon;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.nhanVienByMaNhanVien = nhanVienByMaNhanVien;
    }
}
