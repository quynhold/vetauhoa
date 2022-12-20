package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import vetauhoa.entity.TaiKhoan;

import java.util.List;
@Repository
public interface TaiKhoanDao {
    public void addTaiKhoan(TaiKhoan taiKhoan);
    public void updateTaiKhoan(TaiKhoan taiKhoan);
    public void deleteTaiKhoan(String maTaiKhoan);
    public TaiKhoan getTaiKhoanById(String maTaiKhoan);
    public TaiKhoan getTaiKhoanByUsername(String username);
    public List<TaiKhoan> getTaiKhoanByTrangThai(boolean trangThai);
    public List<TaiKhoan> getAllTaiKhoans();
    public List<String> getAllMaTaiKhoan();
}
