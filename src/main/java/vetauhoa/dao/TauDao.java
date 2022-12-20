package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import vetauhoa.entity.Tau;

import java.util.List;
@Repository
public interface TauDao {
    public void addTau(Tau tau);
    public void updateTau(Tau tau);
    public void deleteTau(String maTau);
    public Tau getTauById(String maTau);
    public List<Tau> getAllTaus();
}
