package vetauhoa.dao;

import vetauhoa.entity.ChoDat;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChoDatDao {
    public void addChoDat(ChoDat choDat);
    public void updateChoDat(ChoDat choDat);
    public void deleteChoDat(String maChoDat);
    public ChoDat getChoDatById(String maChoDat);
    public List<ChoDat> getChoDatsByToaId(String maToa);
    public List<ChoDat> getChoDatsByTauId(String maTau);
    public List<ChoDat> getAllChoDats();
}
