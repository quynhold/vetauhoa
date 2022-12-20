package vetauhoa.service.impl;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.VeDao;
import vetauhoa.entity.Ve;
import vetauhoa.service.VeService;
import org.springframework.stereotype.Service;
import vetauhoa.validator.RandomId;

import java.util.List;
@Service("veService")
public class VeServiceImpl implements VeService {
    @Autowired
    private VeDao veDao;
    public void setVeDao(VeDao veDao) {
        this.veDao = veDao;
    }
    @Override
    public void addVe(Ve ve){this.veDao.addVe(ve);}
    @Override
    public void updateVe(Ve ve){this.veDao.updateVe(ve);}
    @Override
    public void deleteVe(String maVe){this.veDao.deleteVe(maVe);}
    @Override
    public Ve getVeById(String maVe){return this.veDao.getVeById(maVe);}
    @Override
    public List<Ve> getVesByPhieuDatId(String maPhieuDat){return this.veDao.getVesByPhieuDatId(maPhieuDat);}
    @Override
    public List<Ve> getAllVes(){return this.veDao.getAllVes();}

}
