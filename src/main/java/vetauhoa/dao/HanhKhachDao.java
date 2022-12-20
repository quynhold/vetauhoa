package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.entity.HanhKhach;

import java.util.List;
@Repository
public interface HanhKhachDao {
    public void addHanhKhach(HanhKhach hanhKhach);
    public void updateHanhKhach(HanhKhach hanhKhach);
    public void deleteHanhKhach(String maHanhKhach);
    public HanhKhach getHanhKhachById(String maHanhKhach);
    public HanhKhach getHanhKhachsByCccd(String cccd);
    public HanhKhach getHanhKhachsByTaiKhoanId(String maTaiKhoan);
    public HanhKhach getHanhKhachsByEmail(String email);
    public List<HanhKhach> getAllHanhKhachs();
    public List<String> getAllMaHanhKhach();
    public boolean checkMaTaiKhoan(String maTaiKhoan);
    public boolean checkEmail(String email);
    public boolean checkCccd(String cccd);
}
