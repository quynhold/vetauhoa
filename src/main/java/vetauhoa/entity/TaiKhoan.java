package vetauhoa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Base64;
import java.util.Collection;
import java.util.Objects;

@Entity
public class TaiKhoan implements Serializable {
    @Id
    @Column(name = "MaTaiKhoan", nullable = false, length = 12)
    private String maTaiKhoan;

    @Basic
    @Column(name = "Username", nullable = false, length = 20)
    private String username;
    @Basic
    @Column(name = "Password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "TrangThai", nullable = false)
    private boolean trangThai;
    @Basic
    @Column(name = "Role", nullable = false)
    private String role;
    @Basic
    @Column(name = "Avatar", nullable = true)
    private byte[] avatar;
    @OneToMany(mappedBy = "taiKhoanByMaTaiKhoan")
    private Collection<HanhKhach> hanhKhachesByMaTaiKhoan;

    @OneToMany(mappedBy = "taiKhoanByMaTaiKhoan")
    private Collection<NhanVien> nhanViensByMaTaiKhoan;
    private String verifyCode;

    public TaiKhoan(String maTaiKhoan, String username, String password, boolean trangThai, String role, byte[] avatar, Collection<HanhKhach> hanhKhachesByMaTaiKhoan, Collection<NhanVien> nhanViensByMaTaiKhoan, String verifyCode) {
        this.maTaiKhoan = maTaiKhoan;
        this.username = username;
        this.password = password;
        this.trangThai = trangThai;
        this.role = role;
        this.avatar = avatar;
        this.hanhKhachesByMaTaiKhoan = hanhKhachesByMaTaiKhoan;
        this.nhanViensByMaTaiKhoan = nhanViensByMaTaiKhoan;
        this.verifyCode = verifyCode;
    }

    public byte[] getAvatar() {
        return avatar;
    }
    public String getByteAvatar(){
        return avatar==null ? "": Base64.getEncoder().encodeToString(avatar);
    }
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public TaiKhoan(String maTaiKhoan, String username, String password, boolean trangThai) {
        this.maTaiKhoan = maTaiKhoan;
        this.username = username;
        this.password = password;
        this.trangThai = trangThai;
    }

    public TaiKhoan(){}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof TaiKhoan)) return false;
//        TaiKhoan taiKhoan = (TaiKhoan) o;
//        return isTrangThai() == taiKhoan.isTrangThai() && getMaTaiKhoan().equals(taiKhoan.getMaTaiKhoan()) && getUsername().equals(taiKhoan.getUsername()) && getPassword().equals(taiKhoan.getPassword()) && getHanhKhachesByMaTaiKhoan().equals(taiKhoan.getHanhKhachesByMaTaiKhoan()) && getNhanViensByMaTaiKhoan().equals(taiKhoan.getNhanViensByMaTaiKhoan());
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getMaTaiKhoan(), getUsername(), getPassword(), isTrangThai(), getHanhKhachesByMaTaiKhoan(), getNhanViensByMaTaiKhoan());
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }



    public Collection<HanhKhach> getHanhKhachesByMaTaiKhoan() {
        return hanhKhachesByMaTaiKhoan;
    }

    public void setHanhKhachesByMaTaiKhoan(Collection<HanhKhach> hanhKhachesByMaTaiKhoan) {
        this.hanhKhachesByMaTaiKhoan = hanhKhachesByMaTaiKhoan;
    }

    public Collection<NhanVien> getNhanViensByMaTaiKhoan() {
        return nhanViensByMaTaiKhoan;
    }

    public void setNhanViensByMaTaiKhoan(Collection<NhanVien> nhanViensByMaTaiKhoan) {
        this.nhanViensByMaTaiKhoan = nhanViensByMaTaiKhoan;
    }

}
