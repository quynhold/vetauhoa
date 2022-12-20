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

@Entity
public class Ga implements Serializable {
    @Id
    @Column(name = "MaGa", nullable = false, length = 20)
    private String maGa;
    @Basic
    @Column(name = "TenGa", nullable = false, length = 30)
    private String tenGa;
    @Basic
    @Column(name = "DiaChi", nullable = false, length = 50)
    private String diaChi;
    @Basic
    @Column(name = "KhoangCach", nullable = false)
    private int khoangCach;
    @OneToMany(mappedBy = "gaByMaGaXuatPhat")
    private Collection<LichTrinh> lichTrinhsByMaGaXuatPhat;
    @OneToMany(mappedBy = "gaByMaGaCuoi")
    private Collection<LichTrinh> lichTrinhsByMaGaCuoi;
    @OneToMany(mappedBy = "gaByMaGaDen")
    private Collection<PhieuDat> phieuDatsByMaGa;

    public String getMaGa() {
        return maGa;
    }

    public void setMaGa(String maGa) {
        this.maGa = maGa;
    }

    public String getTenGa() {
        return tenGa;
    }

    public void setTenGa(String tenGa) {
        this.tenGa = tenGa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(int khoangCach) {
        this.khoangCach = khoangCach;
    }

    public Collection<LichTrinh> getLichTrinhsByMaGaXuatPhat() {
        return lichTrinhsByMaGaXuatPhat;
    }

    public void setLichTrinhsByMaGaXuatPhat(Collection<LichTrinh> lichTrinhsByMaGaXuatPhat) {
        this.lichTrinhsByMaGaXuatPhat = lichTrinhsByMaGaXuatPhat;
    }

    public Collection<LichTrinh> getLichTrinhsByMaGaCuoi() {
        return lichTrinhsByMaGaCuoi;
    }

    public void setLichTrinhsByMaGaCuoi(Collection<LichTrinh> lichTrinhsByMaGaCuoi) {
        this.lichTrinhsByMaGaCuoi = lichTrinhsByMaGaCuoi;
    }

    public Collection<PhieuDat> getPhieuDatsByMaGa() {
        return phieuDatsByMaGa;
    }

    public void setPhieuDatsByMaGa(Collection<PhieuDat> phieuDatsByMaGa) {
        this.phieuDatsByMaGa = phieuDatsByMaGa;
    }

    public Ga(){}
    public Ga(String maGa, String tenGa, String diaChi, int khoangCach) {
        this.maGa = maGa;
        this.tenGa = tenGa;
        this.diaChi = diaChi;
        this.khoangCach = khoangCach;
    }
}
