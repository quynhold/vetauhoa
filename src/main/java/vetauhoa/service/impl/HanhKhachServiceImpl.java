package vetauhoa.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.HanhKhachDao;
import vetauhoa.entity.HanhKhach;
import vetauhoa.service.HanhKhachService;
import org.springframework.stereotype.Service;
import vetauhoa.validator.RandomId;

import java.util.List;

@Service("hanhKhachService")
public class HanhKhachServiceImpl implements HanhKhachService {
    @Autowired
    private HanhKhachDao hanhKhachDao;
    public void setHanhKhachDao(HanhKhachDao hanhKhachDao) {
        this.hanhKhachDao = hanhKhachDao;
    }
    @Override
    public void addHanhKhach(HanhKhach hanhKhach){this.hanhKhachDao.addHanhKhach(hanhKhach);}
    @Override
    public void updateHanhKhach(HanhKhach hanhKhach){this.hanhKhachDao.updateHanhKhach(hanhKhach);}
    @Override
    public void deleteHanhKhach(String maHanhKhach){this.hanhKhachDao.deleteHanhKhach(maHanhKhach);}
    @Override
    public HanhKhach getHanhKhachById(String maHanhKhach){return this.hanhKhachDao.getHanhKhachById(maHanhKhach);}
    @Override
    public HanhKhach getHanhKhachsByTaiKhoanId(String maTaiKhoan){return this.hanhKhachDao.getHanhKhachsByTaiKhoanId(maTaiKhoan);}
    @Override
    public HanhKhach getHanhKhachsByCccd(String cccd){return this.hanhKhachDao.getHanhKhachsByCccd(cccd);}
    @Override
    public HanhKhach getHanhKhachsByEmail(String email){return this.hanhKhachDao.getHanhKhachsByEmail(email);}
    @Override
    public List<HanhKhach> getAllHanhKhachs(){return this.hanhKhachDao.getAllHanhKhachs();}
    @Override
    public List<String> getAllMaHanhKhach(){return this.hanhKhachDao.getAllMaHanhKhach();}
    @Override
    public String randomMaHanhKhach(){
        String randomMaHanhKhach;
        RandomId randomId = new RandomId();
        List<String> stringList= this.getAllMaHanhKhach();
        do {
            randomMaHanhKhach ="MHK"+ RandomStringUtils.randomNumeric(6);

        }while (!randomId.testId(stringList,randomMaHanhKhach));
        return  randomMaHanhKhach;
    }
    @Override
    public boolean checkMaTaiKhoan(String maTaiKhoan){
      return this.hanhKhachDao.checkMaTaiKhoan(maTaiKhoan);
    }
    @Override
    public boolean checkEmail(String email){return this.hanhKhachDao.checkEmail(email);}
    @Override
    public boolean checkCccd(String cccd){return this.hanhKhachDao.checkCccd(cccd);}
}
