package vetauhoa.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.HoaDonDao;
import vetauhoa.entity.HoaDon;
import vetauhoa.service.HoaDonService;
import org.springframework.stereotype.Service;
import vetauhoa.validator.RandomId;

import javax.persistence.Access;
import java.util.List;

@Service("hoaDonService")
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonDao hoaDonDao;
    public void setHoaDonDao(HoaDonDao hoaDonDao) {
        this.hoaDonDao = hoaDonDao;
    }
    @Override
    public void addHoaDon(HoaDon hoaDon){this.hoaDonDao.addHoaDon(hoaDon);}
    @Override
    public void updateHoaDon(HoaDon hoaDon){this.hoaDonDao.updateHoaDon(hoaDon);}
    @Override
    public void deleteHoaDon(String maHoaDon){this.hoaDonDao.deleteHoaDon(maHoaDon);}
    @Override
    public HoaDon getHoaDon(String maHoaDon){return this.hoaDonDao.getHoaDon(maHoaDon);}
    @Override
    public List<HoaDon> getHoaDonByNhanVienId(String maNhanVien){return this.hoaDonDao.getHoaDonByNhanVienId(maNhanVien);}
    @Override
    public List<HoaDon> getAllHoaDons(){return this.hoaDonDao.getAllHoaDons();}
    @Override
    public List<String> getAllMaHoaDon(){return this.hoaDonDao.getAllMaHoaDon();}
    @Override
    public String randomMaHoaDon(){
        String randomMaHoaDon;
        RandomId randomId = new RandomId();
        List<String> stringList= getAllMaHoaDon();
        do {
            randomMaHoaDon = "MHD" + RandomStringUtils.randomNumeric(6);

        }while (!randomId.testId(stringList,randomMaHoaDon));
        System.out.println(randomMaHoaDon);
        return  randomMaHoaDon;
    }
}
