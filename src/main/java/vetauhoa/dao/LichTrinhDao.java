package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.entity.LichTrinh;

import java.util.Date;
import java.util.List;
@Repository
public interface LichTrinhDao {
    public void addLichTrinh(LichTrinh lichTrinh);
    public void updateLichTrinh(LichTrinh lichTrinh);
    public void deleteLichTrinh(String maLichTrinh);
    public LichTrinh getLichTrinh(String maLichTrinh);
    public List<LichTrinh> getAllLichTrinhs();
    public List<LichTrinh> searchLichTrinhs(String maGaDi,int giaTriGaToi,String ngayDi);
    public List<String> getAllMaLichTrinh();
}
