package vetauhoa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "HanhKhach")
public class HanhKhach implements Serializable {
    @Id
    @Column(name = "MaHanhKhach", nullable = false, length = 12)
    private String maHanhKhach;
    @Basic
    @Column(name = "Ho", nullable = false, length = 10)
    private String ho;
    @Basic
    @Column(name = "Ten", nullable = false, length = 30)
    private String ten;
    @Basic
    @Column(name = "CCCD", nullable = true, length = 12)
    private String cccd;
    @Basic
    @Column(name = "NgaySinh", nullable = true)
    private Date ngaySinh;
    @Basic
    @Column(name = "GioiTinh", nullable = true, length = 4)
    private String gioiTinh;
    @Basic
    @Column(name = "DiaChi", nullable = true, length = 50)
    private String diaChi;
    @Basic
    @Column(name = "Sdt", nullable = false, length = 10)
    private String sdt;
    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    private String email;

//    public String getMaTaiKhoan() {
//        return maTaiKhoan;
//    }
//
//    public void setMaTaiKhoan(String maTaiKhoan) {
//        this.maTaiKhoan = maTaiKhoan;
//    }
//
//    @Basic
//    @Column(name = "MaTaiKhoan", nullable = true, length = 12)
//    private String maTaiKhoan;
    @ManyToOne
    @JoinColumn(name = "MaTaiKhoan", referencedColumnName = "MaTaiKhoan",nullable = true)
    private TaiKhoan taiKhoanByMaTaiKhoan;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy = "maHanhKhach")
    private Collection<PhieuDat> phieuDatsByMaHanhKhach;

    public HanhKhach() {
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof HanhKhach)) return false;
//        HanhKhach hanhKhach = (HanhKhach) o;
//        return getMaHanhKhach().equals(hanhKhach.getMaHanhKhach()) && getHo().equals(hanhKhach.getHo()) && getTen().equals(hanhKhach.getTen()) && getCccd().equals(hanhKhach.getCccd()) && getNgaySinh().equals(hanhKhach.getNgaySinh()) && getGioiTinh().equals(hanhKhach.getGioiTinh()) && getDiaChi().equals(hanhKhach.getDiaChi()) && getSdt().equals(hanhKhach.getSdt()) && getEmail().equals(hanhKhach.getEmail()) && getTaiKhoanByMaTaiKhoan().equals(hanhKhach.getTaiKhoanByMaTaiKhoan()) && getPhieuDatsByMaHanhKhach().equals(hanhKhach.getPhieuDatsByMaHanhKhach());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getMaHanhKhach(), getHo(), getTen(), getCccd(), getNgaySinh(), getGioiTinh(), getDiaChi(), getSdt(), getEmail(), getTaiKhoanByMaTaiKhoan(), getPhieuDatsByMaHanhKhach());
//    }

    public String getMaHanhKhach() {
        return maHanhKhach;
    }

    public void setMaHanhKhach(String maHanhKhach) {
        this.maHanhKhach = maHanhKhach;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TaiKhoan getTaiKhoanByMaTaiKhoan() {
        return taiKhoanByMaTaiKhoan;
    }

    public void setTaiKhoanByMaTaiKhoan(TaiKhoan taiKhoanByMaTaiKhoan) {
        this.taiKhoanByMaTaiKhoan = taiKhoanByMaTaiKhoan;
    }

    public Collection<PhieuDat> getPhieuDatsByMaHanhKhach() {
        return phieuDatsByMaHanhKhach;
    }

    public void setPhieuDatsByMaHanhKhach(Collection<PhieuDat> phieuDatsByMaHanhKhach) {
        this.phieuDatsByMaHanhKhach = phieuDatsByMaHanhKhach;
    }

    public HanhKhach(String maHanhKhach, String ho, String ten, String cccd, Date ngaySinh, String gioiTinh, String diaChi, String sdt, String email, TaiKhoan taiKhoanByMaTaiKhoan) {
        this.maHanhKhach = maHanhKhach;
        this.ho = ho;
        this.ten = ten;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.taiKhoanByMaTaiKhoan = taiKhoanByMaTaiKhoan;
    }
}
