package vetauhoa.service;

import org.springframework.stereotype.Service;
import vetauhoa.entity.HanhKhach;

import java.util.List;
@Service
public interface HanhKhachService {
    public void addHanhKhach(HanhKhach hanhKhach);
    public void updateHanhKhach(HanhKhach hanhKhach);
    public void deleteHanhKhach(String maHanhKhach);
    public HanhKhach getHanhKhachById(String maHanhKhach);
    public HanhKhach getHanhKhachsByTaiKhoanId(String maTaiKhoan);
    public HanhKhach getHanhKhachsByCccd(String cccd);
    public HanhKhach getHanhKhachsByEmail(String email);
    public List<HanhKhach> getAllHanhKhachs();
    public List<String> getAllMaHanhKhach();
    public String randomMaHanhKhach();
    public boolean checkMaTaiKhoan(String maTaiKhoan);
    public boolean checkEmail(String email);
    public boolean checkCccd(String cccd);
}
