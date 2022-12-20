package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.Ve;

import java.util.List;
@Service

public interface VeService {
    public void addVe(Ve ve);
    public void updateVe(Ve ve);
    public void deleteVe(String maVe);
    public Ve getVeById(String maVe);
    public List<Ve> getVesByPhieuDatId(String maPhieuDat);
    public List<Ve> getAllVes();

}

