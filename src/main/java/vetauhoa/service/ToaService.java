package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.Toa;

import java.util.List;
@Service
public interface ToaService {
    public void addToa(Toa toa);
    public void updateTao(Toa toa);
    public void deleteToa(String maToa);
    public Toa getToaById(String maToa);
    public List<Toa> getToasByTauId(String maTau);
    public List<Toa> getToasByLoaiCho(String maTau,String loaiCho);
    public List<Toa> getAllToas();
}
