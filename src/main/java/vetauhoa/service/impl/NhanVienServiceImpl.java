package vetauhoa.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.NhanVienDao;
import vetauhoa.entity.NhanVien;
import vetauhoa.service.NhanVienService;
import org.springframework.stereotype.Service;
import vetauhoa.validator.RandomId;

import java.util.List;

@Service("nhanVienService")
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienDao nhanVienDao;
    public void setNhanVienDao(NhanVienDao nhanVienDao) {
        this.nhanVienDao = nhanVienDao;
    }
    @Override
    public void addNhanVien(NhanVien nhanVien){this.nhanVienDao.addNhanVien(nhanVien);}
    @Override
    public void updateNhanVien(NhanVien nhanVien){this.nhanVienDao.updateNhanVien(nhanVien);}
    @Override
    public void deleteNhanVien(String maNhanVien){this.nhanVienDao.deleteNhanVien(maNhanVien);}
    @Override
    public NhanVien getNhanVienById(String maNhanVien){return this.nhanVienDao.getNhanVienById(maNhanVien);}
    @Override
    public NhanVien getNhanViensByTaiKhoanId(String maTaiKhoan){return this.nhanVienDao.getNhanViensByTaiKhoanId(maTaiKhoan);}
    @Override
    public List<NhanVien> getAllNhanViens(){return this.nhanVienDao.getAllNhanViens();}
    @Override
    public boolean checkMaTaiKhoan(String maTaiKhoan){return this.nhanVienDao.checkMaTaiKhoan(maTaiKhoan);}
    @Override
    public boolean checkEmail(String email){return this.nhanVienDao.checkEmail(email);}
    @Override
    public List<String> getAllMaNhanVien(){return this.nhanVienDao.getAllMaNhanVien();}
    @Override
    public String randomMaNhanVien(){
        String randomMaNhanVien;
        RandomId randomId = new RandomId();
        List<String> stringList= this.getAllMaNhanVien();
        do {
            randomMaNhanVien ="MNV"+ RandomStringUtils.randomNumeric(6);

        }while (!randomId.testId(stringList,randomMaNhanVien));
        return  randomMaNhanVien;
    }
}
