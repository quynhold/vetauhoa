package vetauhoa.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.ToaDao;
import vetauhoa.entity.Toa;
import vetauhoa.service.ToaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("toaService")
public class ToaServiceImpl implements ToaService {
    @Autowired
    private ToaDao toaDao;
    public void setToaDao(ToaDao toaDao) {
        this.toaDao = toaDao;
    }
    @Override
    public void addToa(Toa toa){this.toaDao.addToa(toa);}
    @Override
    public void updateTao(Toa toa){this.toaDao.updateTao(toa);}
    @Override
    public void deleteToa(String maToa){this.toaDao.deleteToa(maToa);}
    @Override
    public Toa getToaById(String maToa){return this.toaDao.getToaById(maToa);}
    @Override
    public List<Toa> getToasByTauId(String maTau){return this.toaDao.getToasByTauId(maTau);}
    @Override
    public List<Toa> getToasByLoaiCho(String maTau,String loaiCho){return this.toaDao.getToasByLoaiCho(maTau,loaiCho);}
    @Override
    public List<Toa> getAllToas(){return this.toaDao.getAllToas();}
}
