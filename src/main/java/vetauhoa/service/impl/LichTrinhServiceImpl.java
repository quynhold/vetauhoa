package vetauhoa.service.impl;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.LichTrinhDao;
import vetauhoa.entity.LichTrinh;
import vetauhoa.service.LichTrinhService;
import org.springframework.stereotype.Service;
import vetauhoa.validator.RandomId;

import java.util.Date;
import java.util.List;

@Service("lichTrinhService")
public class LichTrinhServiceImpl implements LichTrinhService {
    @Autowired
    private LichTrinhDao lichTrinhDao;
    public void setLichTrinhDao(LichTrinhDao lichTrinhDao) {
        this.lichTrinhDao = lichTrinhDao;
    }
    @Override
    public void addLichTrinh(LichTrinh lichTrinh){this.lichTrinhDao.addLichTrinh(lichTrinh);}
    @Override
    public void updateLichTrinh(LichTrinh lichTrinh){this.lichTrinhDao.updateLichTrinh(lichTrinh);}
    @Override
    public void deleteLichTrinh(String maLichTrinh){this.lichTrinhDao.deleteLichTrinh(maLichTrinh);}
    @Override
    public LichTrinh getLichTrinh(String maLichTrinh){return this.lichTrinhDao.getLichTrinh(maLichTrinh);}
    @Override
    public List<LichTrinh> getAllLichTrinhs(){return  this.lichTrinhDao.getAllLichTrinhs();}
    @Override
    public List<LichTrinh> searchLichTrinhs(String maGaDi, int giaTriGaToi, String ngayDi){
        return this.lichTrinhDao.searchLichTrinhs(maGaDi,giaTriGaToi,ngayDi);
    }
    @Override
    public List<String> getAllMaLichTrinh(){return this.lichTrinhDao.getAllMaLichTrinh();}
    @Override
    public String randomMaLichTrinh(){
        String randomMaLichTrinh;
        RandomId randomId = new RandomId();
        List<String> stringList= this.getAllMaLichTrinh();
        do {
            randomMaLichTrinh ="MLT"+ RandomStringUtils.randomNumeric(7);

        }while (!randomId.testId(stringList,randomMaLichTrinh));
        return  randomMaLichTrinh;
    }
}
