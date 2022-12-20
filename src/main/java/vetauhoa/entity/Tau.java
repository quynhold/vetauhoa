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
public class Tau implements Serializable {

    @Id
    @Column(name = "MaTau", nullable = false, length = 5)
    private String maTau;

    @Basic
    @Column(name = "BienSo", nullable = false, length = 8)
    private String bienSo;
    @OneToMany(mappedBy = "tauByMaTau")
    private Collection<LichTrinh> lichTrinhsByMaTau;

    @OneToMany(mappedBy = "tauByMaTau")
    private Collection<Toa> toasByMaTau;

    public String getMaTau() {
        return maTau;
    }
    public Tau(){}
    public void setMaTau(String maTau) {
        this.maTau = maTau;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }




    public Collection<LichTrinh> getLichTrinhsByMaTau() {
        return lichTrinhsByMaTau;
    }

    public void setLichTrinhsByMaTau(Collection<LichTrinh> lichTrinhsByMaTau) {
        this.lichTrinhsByMaTau = lichTrinhsByMaTau;
    }

    public Collection<Toa> getToasByMaTau() {
        return toasByMaTau;
    }

    public Tau(String maTau, String bienSo) {
        this.maTau = maTau;
        this.bienSo = bienSo;
    }

    public void setToasByMaTau(Collection<Toa> toasByMaTau) {
        this.toasByMaTau = toasByMaTau;
    }
}
