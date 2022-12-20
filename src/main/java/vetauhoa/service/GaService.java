package vetauhoa.service;

import org.springframework.stereotype.Service;
import vetauhoa.entity.Ga;
import vetauhoa.entity.LichTrinh;

import java.util.Date;
import java.util.List;
@Service
public interface GaService {
    public void addGa(Ga ga);
    public void updateGa(Ga ga);
    public void deleteGa(String maGa);
    public Ga getGaById(String maGa);
    public List<Ga> getAllGas();
    public Ga getGaByTenGa(String tenGa);
}
