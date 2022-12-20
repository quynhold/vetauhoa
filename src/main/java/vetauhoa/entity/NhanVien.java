package vetauhoa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class NhanVien implements Serializable {
    @Id
    @Column(name = "MaNhanVien", nullable = false, length = 12)
    private String maNhanVien;
    @Basic
    @Column(name = "Ho", nullable = false, length = 10)
    private String ho;
    @Basic
    @Column(name = "Ten", nullable = false, length = 30)
    private String ten;
    @Basic
    @Column(name = "NgaySinh", nullable = false)
    private Date ngaySinh;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Collection<HoaDon> getHoaDonsByMaNhanVien() {
        return hoaDonsByMaNhanVien;
    }

    public void setHoaDonsByMaNhanVien(Collection<HoaDon> hoaDonsByMaNhanVien) {
        this.hoaDonsByMaNhanVien = hoaDonsByMaNhanVien;
    }

    public TaiKhoan getTaiKhoanByMaTaiKhoan() {
        return taiKhoanByMaTaiKhoan;
    }

    public void setTaiKhoanByMaTaiKhoan(TaiKhoan taiKhoanByMaTaiKhoan) {
        this.taiKhoanByMaTaiKhoan = taiKhoanByMaTaiKhoan;
    }
    public NhanVien(){}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhanVien)) return false;
        NhanVien nhanVien = (NhanVien) o;
        return getMaNhanVien().equals(nhanVien.getMaNhanVien()) && getHo().equals(nhanVien.getHo()) && getTen().equals(nhanVien.getTen()) && getNgaySinh().equals(nhanVien.getNgaySinh()) && getHoaDonsByMaNhanVien().equals(nhanVien.getHoaDonsByMaNhanVien()) && getTaiKhoanByMaTaiKhoan().equals(nhanVien.getTaiKhoanByMaTaiKhoan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaNhanVien(), getHo(), getTen(), getNgaySinh(), getHoaDonsByMaNhanVien(), getTaiKhoanByMaTaiKhoan());
    }

    //    @Basic
//    @Column(name = "MaTaiKhoan", nullable = false, length = 12)
//    private String maTaiKhoan;
    @OneToMany(mappedBy = "nhanVienByMaNhanVien")
    private Collection<HoaDon> hoaDonsByMaNhanVien;
    @ManyToOne
    @JoinColumn(name = "MaTaiKhoan", referencedColumnName = "MaTaiKhoan", nullable = true)
    private TaiKhoan taiKhoanByMaTaiKhoan;

    public NhanVien(String maNhanVien, String ho, String ten, Date ngaySinh, TaiKhoan taiKhoanByMaTaiKhoan) {
        this.maNhanVien = maNhanVien;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.taiKhoanByMaTaiKhoan = taiKhoanByMaTaiKhoan;
    }
}
