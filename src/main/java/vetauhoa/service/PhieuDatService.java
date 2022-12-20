package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.PhieuDat;

import java.math.BigInteger;
import java.util.List;
@Service
public interface PhieuDatService {
    public void addPhieuDat(PhieuDat phieuDat);
    public void updatePhieuDat(PhieuDat phieuDat);
    public void deletePhieuDat(String maPhieuDat);
    public PhieuDat getPhieuDatById(String maPhieuDat);
    public List<PhieuDat> getPhieuDatsByHanhKhachId(String maHanhKhach);
    public List<PhieuDat> getPhieuDatsByHoaDonId(String maHoaDon);
    public List<PhieuDat> getPhieuDatsByLichTrinhId(String maLichTrinh);
    public List<String> getAllMaPhieuDat();
    public String randomMaPhieuDat();
    public List<PhieuDat> getAllPhieuDat();
}
