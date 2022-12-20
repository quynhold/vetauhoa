package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.entity.HoaDon;

import java.util.List;
@Repository
public interface HoaDonDao {
    public void addHoaDon(HoaDon hoaDon);
    public void updateHoaDon(HoaDon hoaDon);
    public void deleteHoaDon(String maHoaDon);
    public HoaDon getHoaDon(String maHoaDon);
    public List<HoaDon> getHoaDonByNhanVienId(String maNhanVien);
    public List<HoaDon> getAllHoaDons();
    public List<String> getAllMaHoaDon();
}