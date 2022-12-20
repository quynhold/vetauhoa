package vetauhoa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "LichTrinh")
public class LichTrinh implements Serializable {
    @Id
    @Column(name = "MaLichTrinh", nullable = false, length = 10)
    private String maLichTrinh;
//    @Basic
//    @Column(name = "MaTau", nullable = false, length = 5,insertable = false,updatable = false)
//    private String maTau;
//    @Basic
//    @Column(name = "MaGaXuatPhat", nullable = false, length = 20,insertable = false,updatable = false)
//    private String maGaXuatPhat;
    @Basic
    @Column(name = "ThoiGianXuatPhat", nullable = false)
    private Timestamp thoiGianXuatPhat;

    public String getMaLichTrinh() {
        return maLichTrinh;
    }

    public void setMaLichTrinh(String maLichTrinh) {
        this.maLichTrinh = maLichTrinh;
    }
    public LichTrinh(){}

    public LichTrinh(String maLichTrinh, Timestamp thoiGianXuatPhat, BigDecimal giaMoCua, Tau tauByMaTau, Ga gaByMaGaXuatPhat, Ga gaByMaGaCuoi, Collection<PhieuDat> phieuDatsByMaLichTrinh, Collection<TrangThaiChoDat> trangThaiChoDatsByMaLichTrinh) {
        this.maLichTrinh = maLichTrinh;
        this.thoiGianXuatPhat = thoiGianXuatPhat;
        this.giaMoCua = giaMoCua;
        this.tauByMaTau = tauByMaTau;
        this.gaByMaGaXuatPhat = gaByMaGaXuatPhat;
        this.gaByMaGaCuoi = gaByMaGaCuoi;
        this.phieuDatsByMaLichTrinh = phieuDatsByMaLichTrinh;
        this.trangThaiChoDatsByMaLichTrinh = trangThaiChoDatsByMaLichTrinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LichTrinh)) return false;
        LichTrinh lichTrinh = (LichTrinh) o;
        return Objects.equals(getMaLichTrinh(), lichTrinh.getMaLichTrinh()) && Objects.equals(getThoiGianXuatPhat(), lichTrinh.getThoiGianXuatPhat()) && Objects.equals(getGiaMoCua(), lichTrinh.getGiaMoCua()) && Objects.equals(getTauByMaTau(), lichTrinh.getTauByMaTau()) && Objects.equals(getGaByMaGaXuatPhat(), lichTrinh.getGaByMaGaXuatPhat()) && Objects.equals(getGaByMaGaCuoi(), lichTrinh.getGaByMaGaCuoi()) && Objects.equals(getPhieuDatsByMaLichTrinh(), lichTrinh.getPhieuDatsByMaLichTrinh()) && Objects.equals(getTrangThaiChoDatsByMaLichTrinh(), lichTrinh.getTrangThaiChoDatsByMaLichTrinh());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaLichTrinh(), getThoiGianXuatPhat(), getGiaMoCua(), getTauByMaTau(), getGaByMaGaXuatPhat(), getGaByMaGaCuoi(), getPhieuDatsByMaLichTrinh(), getTrangThaiChoDatsByMaLichTrinh());
    }

    public Collection<TrangThaiChoDat> getTrangThaiChoDatsByMaLichTrinh() {
        return trangThaiChoDatsByMaLichTrinh;
    }

    public void setTrangThaiChoDatsByMaLichTrinh(Collection<TrangThaiChoDat> trangThaiChoDatsByMaLichTrinh) {
        this.trangThaiChoDatsByMaLichTrinh = trangThaiChoDatsByMaLichTrinh;
    }

    public Timestamp getThoiGianXuatPhat() {
        return thoiGianXuatPhat;
    }

    public void setThoiGianXuatPhat(Timestamp thoiGianXuatPhat) {
        this.thoiGianXuatPhat = thoiGianXuatPhat;
    }

    public BigDecimal getGiaMoCua() {
        return giaMoCua;
    }

    public void setGiaMoCua(BigDecimal giaMoCua) {
        this.giaMoCua = giaMoCua;
    }

    public Tau getTauByMaTau() {
        return tauByMaTau;
    }

    public void setTauByMaTau(Tau tauByMaTau) {
        this.tauByMaTau = tauByMaTau;
    }

    public Ga getGaByMaGaXuatPhat() {
        return gaByMaGaXuatPhat;
    }

    public void setGaByMaGaXuatPhat(Ga gaByMaGaXuatPhat) {
        this.gaByMaGaXuatPhat = gaByMaGaXuatPhat;
    }

    public Ga getGaByMaGaCuoi() {
        return gaByMaGaCuoi;
    }

    public void setGaByMaGaCuoi(Ga gaByMaGaCuoi) {
        this.gaByMaGaCuoi = gaByMaGaCuoi;
    }

    public Collection<PhieuDat> getPhieuDatsByMaLichTrinh() {
        return phieuDatsByMaLichTrinh;
    }

    public void setPhieuDatsByMaLichTrinh(Collection<PhieuDat> phieuDatsByMaLichTrinh) {
        this.phieuDatsByMaLichTrinh = phieuDatsByMaLichTrinh;
    }

    //    @Basic
//    @Column(name = "MaGaCuoi", nullable = false, length = 20,insertable = false,updatable = false)
//    private String maGaCuoi;
    @Basic
    @Column(name = "GiaMoCua", nullable = false)
    private BigDecimal giaMoCua;
    @ManyToOne
    @JoinColumn(name = "MaTau", referencedColumnName = "MaTau", nullable = false)
    private Tau tauByMaTau;
    @ManyToOne
    @JoinColumn(name = "MaGaXuatPhat", referencedColumnName = "MaGa", nullable = false)
    private Ga gaByMaGaXuatPhat;
    @ManyToOne
    @JoinColumn(name = "MaGaCuoi", referencedColumnName = "MaGa", nullable = false)
    private Ga gaByMaGaCuoi;
    @OneToMany(mappedBy = "lichTrinhByMaLichTrinh")
    private Collection<PhieuDat> phieuDatsByMaLichTrinh;

    @OneToMany(mappedBy = "lichTrinhByMaLichTrinh")
    private Collection<TrangThaiChoDat> trangThaiChoDatsByMaLichTrinh;


}
