package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.Tau;

import java.util.List;
@Service
public interface TauService {
    public void addTau(Tau tau);
    public void updateTau(Tau tau);
    public void deleteTau(String maTau);
    public Tau getTauById(String maTau);
    public List<Tau> getAllTaus();
}
