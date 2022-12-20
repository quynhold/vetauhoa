package vetauhoa.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.PhieuDatDao;
import vetauhoa.entity.PhieuDat;
import vetauhoa.service.PhieuDatService;
import org.springframework.stereotype.Service;
import vetauhoa.validator.RandomId;
import java.util.List;

@Service("phieuDatService")
public class PhieuDatServiceImpl implements PhieuDatService {
    @Autowired
    private PhieuDatDao phieuDatDao;
    public void setPhieuDatDao(PhieuDatDao phieuDatDao) {
        this.phieuDatDao = phieuDatDao;
    }
    @Override
    public void addPhieuDat(PhieuDat phieuDat){this.phieuDatDao.addPhieuDat(phieuDat);}
    @Override
    public void updatePhieuDat(PhieuDat phieuDat){this.phieuDatDao.updatePhieuDat(phieuDat);}
    @Override
    public void deletePhieuDat(String maPhieuDat){this.phieuDatDao.deletePhieuDat(maPhieuDat);}
    @Override
    public PhieuDat getPhieuDatById(String maPhieuDat){return this.phieuDatDao.getPhieuDatById(maPhieuDat);}
    @Override
    public List<PhieuDat> getPhieuDatsByHanhKhachId(String maHanhKhach){return this.phieuDatDao.getPhieuDatsByHanhKhachId(maHanhKhach);}
    @Override
    public List<PhieuDat> getPhieuDatsByHoaDonId(String maHoaDon){return this.phieuDatDao.getPhieuDatsByHoaDonId(maHoaDon);}
    @Override
    public List<PhieuDat> getPhieuDatsByLichTrinhId(String maLichTrinh){return this.phieuDatDao.getPhieuDatsByLichTrinhId(maLichTrinh);}
    @Override
    public List<String> getAllMaPhieuDat(){return this.phieuDatDao.getAllMaPhieuDat();}
    @Override
    public List<PhieuDat> getAllPhieuDat(){return this.phieuDatDao.getAllPhieuDat();}
    @Override
    public String randomMaPhieuDat(){
        String randomMaPhieuDat;
        RandomId randomId = new RandomId();
        System.out.println("tao bien xong");
        List<String> stringList= getAllMaPhieuDat();
        System.out.println("GetAll phieudat xong");
        do {
            randomMaPhieuDat = RandomStringUtils.randomAlphabetic(4).toUpperCase() + RandomStringUtils.randomNumeric(6);

        }while (!randomId.testId(stringList,randomMaPhieuDat));
        return  randomMaPhieuDat;
    }

}
