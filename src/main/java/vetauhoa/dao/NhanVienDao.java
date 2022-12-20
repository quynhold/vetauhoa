package vetauhoa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.entity.NhanVien;

import java.util.List;
@Repository
public interface NhanVienDao {
        public void addNhanVien(NhanVien nhanVien);
        public void updateNhanVien(NhanVien nhanVien);
        public void deleteNhanVien(String maNhanVien);
        public NhanVien getNhanVienById(String maNhanVien);
        public NhanVien getNhanViensByTaiKhoanId(String maTaiKhoan);
        public List<NhanVien> getAllNhanViens();
        public List<String> getAllMaNhanVien();
        public boolean checkMaTaiKhoan(String maTaiKhoan);
        public boolean checkEmail(String email);
}
