package vetauhoa.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.entity.Toa;

import java.util.List;
@Repository
public interface ToaDao {
    public void addToa(Toa toa);
    public void updateTao(Toa toa);
    public void deleteToa(String maToa);
    public Toa getToaById(String maToa);
    public List<Toa> getToasByTauId(String maTau);
    public List<Toa> getToasByLoaiCho(String maTau,String loaiCho);
    public List<Toa> getAllToas();
//    public int getSoLuongChoTrong(String maToa);
}
