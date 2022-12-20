package vetauhoa.service;

import org.springframework.stereotype.Service;
import vetauhoa.entity.TrangThaiChoDat;

import java.util.List;
@Service
public interface TrangThaiChoDatService{
        public void addTrangThai(TrangThaiChoDat trangThaiChoDat);
        public void updateTrangThai(TrangThaiChoDat trangThaiChoDat);
        public void deleteTrangThai(String maTrangThai);
        public void deleteTrangThai(String maLichTrinh,String maChoDat);
        public TrangThaiChoDat getTrangThaiByMaLTCD(String maLichTrinh,String maChoDat);
        public TrangThaiChoDat getTrangThaiByMaTrangThai(String maTrangThai);
        public List<TrangThaiChoDat> getAllTrangThai();
        public List<TrangThaiChoDat> getAllTrangThaiByMaLichTrinh(String maLichTrinh);
}
