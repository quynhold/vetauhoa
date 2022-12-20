package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.LichTrinh;

import java.util.Date;
import java.util.List;
@Service
public interface LichTrinhService {
    public void addLichTrinh(LichTrinh lichTrinh);
    public void updateLichTrinh(LichTrinh lichTrinh);
    public void deleteLichTrinh(String maLichTrinh);
    public LichTrinh getLichTrinh(String maLichTrinh);
    public List<LichTrinh> getAllLichTrinhs();
    public List<LichTrinh> searchLichTrinhs(String maGaDi, int giaTriGaToi, String ngayDi);
    public List<String> getAllMaLichTrinh();
    public String randomMaLichTrinh();
}
