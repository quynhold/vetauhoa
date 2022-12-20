package vetauhoa.service;


import org.springframework.stereotype.Service;
import vetauhoa.entity.TaiKhoan;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Service
public interface TaiKhoanService {
    public void addTaiKhoan(TaiKhoan taiKhoan);
    public void updateTaiKhoan(TaiKhoan taiKhoan);
    public void deleteTaiKhoan(String maTaiKhoan);
    public TaiKhoan getTaiKhoanById(String maTaiKhoan);
    public TaiKhoan getTaiKhoanByUsername(String username);
    public List<TaiKhoan> getTaiKhoanByTrangThai(boolean trangThai);
    public List<TaiKhoan> getAllTaiKhoans();
    public List<String> getAllMaTaiKhoan();
    public String checkLogin(String username,String password);
    public void sendEmail(HttpServletRequest request, HttpServletResponse response, String from, String toAddress, String subject, String message) throws AddressException, MessagingException, IOException, ServletException;
    public String randomMaTaiKhoan();
}
