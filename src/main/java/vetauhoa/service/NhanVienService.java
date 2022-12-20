package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.NhanVien;

import java.util.List;
@Service
public interface NhanVienService {
    public void addNhanVien(NhanVien nhanVien);
    public void updateNhanVien(NhanVien nhanVien);
    public void deleteNhanVien(String maNhanVien);
    public NhanVien getNhanVienById(String maNhanVien);
    public NhanVien getNhanViensByTaiKhoanId(String maTaiKhoan);
    public List<NhanVien> getAllNhanViens();
    public List<String> getAllMaNhanVien();
    public String randomMaNhanVien();
    public boolean checkMaTaiKhoan(String maTaiKhoan);
    public boolean checkEmail(String email);
}
