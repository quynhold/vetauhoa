package vetauhoa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.GaDao;
import vetauhoa.entity.Ga;
import vetauhoa.entity.LichTrinh;
import vetauhoa.service.GaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("gaService")
public class GaServiceImpl implements GaService {
    @Autowired
    private GaDao gaDao;
    public void setGaDao(GaDao gaDao) {
        this.gaDao = gaDao;
    }
    @Override
    public void addGa(Ga ga){this.gaDao.addGa(ga);}
    @Override
    public void updateGa(Ga ga){this.gaDao.updateGa(ga);}
    @Override
    public void deleteGa(String maGa){this.gaDao.deleteGa(maGa);}
    @Override
    public Ga getGaById(String maGa){return this.gaDao.getGaById(maGa);}
    @Override
    public List<Ga> getAllGas(){return this.gaDao.getAllGas();}
    @Override
    public Ga getGaByTenGa(String tenGa){return this.gaDao.getGaByTenGa(tenGa);}
}
