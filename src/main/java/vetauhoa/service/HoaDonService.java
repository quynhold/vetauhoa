package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.HoaDon;

import java.util.List;
@Service
public interface HoaDonService {

    public void addHoaDon(HoaDon hoaDon);
    public void updateHoaDon(HoaDon hoaDon);
    public void deleteHoaDon(String maHoaDon);
    public HoaDon getHoaDon(String maHoaDon);
    public List<HoaDon> getHoaDonByNhanVienId(String maNhanVien);
    public List<HoaDon> getAllHoaDons();
    public List<String> getAllMaHoaDon();
    public String randomMaHoaDon();
}
