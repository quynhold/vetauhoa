package vetauhoa.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.TauDao;
import vetauhoa.entity.Tau;
import vetauhoa.service.TauService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("tauService")
public class TauServiceImpl implements TauService {
    @Autowired
    private TauDao tauDao;
    public void setTauDao(TauDao tauDao) {
        this.tauDao = tauDao;
    }
    @Override
    public void addTau(Tau tau){this.tauDao.addTau(tau);}
    @Override
    public void updateTau(Tau tau){this.tauDao.updateTau(tau);}
    @Override
    public void deleteTau(String maTau){this.tauDao.deleteTau(maTau);}
    @Override
    public Tau getTauById(String maTau){return this.tauDao.getTauById(maTau);}
    @Override
    public List<Tau> getAllTaus(){return this.tauDao.getAllTaus();}
}
