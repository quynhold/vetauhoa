package vetauhoa.service.impl;


import vetauhoa.dao.ChoDatDao;
import vetauhoa.entity.ChoDat;
import vetauhoa.service.ChoDatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service("choDatService")
public class ChoDatServiceImpl implements ChoDatService {
    @Autowired
    private ChoDatDao choDatDao;
    public void setChoDatDao(ChoDatDao choDatDao) {
        this.choDatDao=choDatDao;
    }
    @Override
    public void addChoDat(ChoDat choDat){this.choDatDao.addChoDat(choDat);}
    @Override
    public void updateChoDat(ChoDat choDat){this.choDatDao.updateChoDat(choDat);}
    @Override
    public void deleteChoDat(String maChoDat){this.choDatDao.deleteChoDat(maChoDat);}
    @Override
    public ChoDat getChoDatById(String maChoDat){return this.choDatDao.getChoDatById(maChoDat);}
    @Override
    public List<ChoDat> getChoDatsByToaId(String maToa){return this.choDatDao.getChoDatsByToaId(maToa);}
    @Override
    public List<ChoDat> getChoDatsByTauId(String maTau){return this.choDatDao.getChoDatsByTauId(maTau);}
    @Override
    public List<ChoDat> getAllChoDats(){return this.choDatDao.getAllChoDats();}
}