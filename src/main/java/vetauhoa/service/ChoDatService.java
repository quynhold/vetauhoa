package vetauhoa.service;

import vetauhoa.entity.ChoDat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ChoDatService {
    public void addChoDat(ChoDat choDat);
    public void updateChoDat(ChoDat choDat);
    public void deleteChoDat(String maChoDat);
    public ChoDat getChoDatById(String maChoDat);
    public List<ChoDat> getChoDatsByToaId(String maToa);
    public List<ChoDat> getChoDatsByTauId(String maTau);
    public List<ChoDat> getAllChoDats();
}