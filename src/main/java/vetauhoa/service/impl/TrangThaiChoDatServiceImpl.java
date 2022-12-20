package vetauhoa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetauhoa.dao.TrangThaiChoDatDao;
import vetauhoa.entity.TrangThaiChoDat;
import vetauhoa.service.TrangThaiChoDatService;

import java.util.List;

@Service("trangThaiChoDatService")
public class TrangThaiChoDatServiceImpl implements TrangThaiChoDatService {
    @Autowired
    TrangThaiChoDatDao trangThaiChoDatDao;
    @Override
    public void addTrangThai(TrangThaiChoDat trangThaiChoDat){this.trangThaiChoDatDao.addTrangThai(trangThaiChoDat);}
    @Override
    public void updateTrangThai(TrangThaiChoDat trangThaiChoDat){this.trangThaiChoDatDao.updateTrangThai(trangThaiChoDat);}
    @Override
    public void deleteTrangThai(String maTrangThai){this.trangThaiChoDatDao.deleteTrangThai(maTrangThai);}
    @Override
    public void deleteTrangThai(String maLichTrinh,String maChoDat){this.trangThaiChoDatDao.deleteTrangThai(maLichTrinh,maChoDat);}
    @Override
    public TrangThaiChoDat getTrangThaiByMaLTCD(String maLichTrinh,String maChoDat){return this.trangThaiChoDatDao.getTrangThaiByMaLTCD(maLichTrinh,maChoDat);}
    @Override
    public TrangThaiChoDat getTrangThaiByMaTrangThai(String maTrangThai){return this.trangThaiChoDatDao.getTrangThaiByMaTrangThai(maTrangThai);}
    @Override
    public List<TrangThaiChoDat> getAllTrangThai(){return this.trangThaiChoDatDao.getAllTrangThai();}
    @Override
    public List<TrangThaiChoDat> getAllTrangThaiByMaLichTrinh(String maLichTrinh){return this.trangThaiChoDatDao.getAllTrangThaiByMaLichTrinh(maLichTrinh);}
}
