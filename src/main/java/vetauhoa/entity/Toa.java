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
public class Toa  implements Serializable {
    @Id
    @Column(name = "MaToa", nullable = false, length = 5)
    private String maToa;
//    @Basic
//    @Column(name = "MaTau", nullable = false, length = 5)
//    private String maTau;
    @Basic
    @Column(name = "LoaiCho", nullable = false, length = 4)
    private String loaiCho;
    @Basic
    @Column(name = "SoLuongCho", nullable = false)
    private int soLuongCho;
    @OneToMany(mappedBy = "toaByMaToa")
    private Collection<ChoDat> choDatsByMaToa;
    @ManyToOne
    @JoinColumn(name = "MaTau", referencedColumnName = "MaTau", nullable = false)
    private Tau tauByMaTau;


    public String getMaToa() {
        return maToa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toa)) return false;
        Toa toa = (Toa) o;
        return getSoLuongCho() == toa.getSoLuongCho() && getMaToa().equals(toa.getMaToa()) && getLoaiCho().equals(toa.getLoaiCho()) && getChoDatsByMaToa().equals(toa.getChoDatsByMaToa()) && getTauByMaTau().equals(toa.getTauByMaTau());
    }
    public Toa(){}

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

//    public String getMaTau() {
//        return maTau;
//    }
//
//    public void setMaTau(String maTau) {
//        this.maTau = maTau;
//    }

    public String getLoaiCho() {
        return loaiCho;
    }

    public void setLoaiCho(String loaiCho) {
        this.loaiCho = loaiCho;
    }


    public int getSoLuongCho() {
        return soLuongCho;
    }

    public void setSoLuongCho(int soLuongCho) {
        this.soLuongCho = soLuongCho;
    }




    public Collection<ChoDat> getChoDatsByMaToa() {
        return choDatsByMaToa;
    }

    public void setChoDatsByMaToa(Collection<ChoDat> choDatsByMaToa) {
        this.choDatsByMaToa = choDatsByMaToa;
    }


    public Tau getTauByMaTau() {
        return tauByMaTau;
    }

    public void setTauByMaTau(Tau tauByMaTau) {
        this.tauByMaTau = tauByMaTau;
    }

    @Override
    public String toString() {
        return "Toa{" +
                "maToa='" + maToa + '\'' +
                ", loaiCho='" + loaiCho + '\'' +
                ", soLuongCho=" + soLuongCho +
                ", tauByMaTau=" + tauByMaTau +
                '}';
    }
}
