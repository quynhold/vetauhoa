package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import vetauhoa.entity.Ga;

import java.util.List;
@Repository
public interface GaDao {
    public void addGa(Ga ga);
    public void updateGa(Ga ga);
    public void deleteGa(String maGa);
    public Ga getGaById(String maGa);
    public Ga getGaByTenGa(String tenGa);
    public List<Ga> getAllGas();
}
