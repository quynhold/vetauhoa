package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import vetauhoa.entity.PhieuDat;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface PhieuDatDao {
    public void addPhieuDat(PhieuDat phieuDat);
    public void updatePhieuDat(PhieuDat phieuDat);
    public void deletePhieuDat(String maPhieuDat);
    public PhieuDat getPhieuDatById(String maPhieuDat);
    public List<PhieuDat> getPhieuDatsByHanhKhachId(String maHanhKhach);
    public List<PhieuDat> getPhieuDatsByHoaDonId(String maHoaDon);
    public List<PhieuDat> getPhieuDatsByLichTrinhId(String maLichTrinh);
    public List<PhieuDat> getAllPhieuDat();
    public List<String> getAllMaPhieuDat();
}
