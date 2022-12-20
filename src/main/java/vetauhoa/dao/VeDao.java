package vetauhoa.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.entity.Ve;

import java.util.List;
@Repository
public interface VeDao {
    public void addVe(Ve ve);
    public void updateVe(Ve ve);
    public void deleteVe(String maVe);
    public Ve getVeById(String maVe);
    public List<Ve> getVesByPhieuDatId(String maPhieuDat);
    public List<Ve> getAllVes();
}
