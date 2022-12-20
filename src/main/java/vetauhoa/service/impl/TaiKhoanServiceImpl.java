package vetauhoa.service.impl;


import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import vetauhoa.dao.TaiKhoanDao;
import vetauhoa.entity.TaiKhoan;
import vetauhoa.service.TaiKhoanService;
import org.springframework.stereotype.Service;
import vetauhoa.validator.RandomId;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Service("taiKhoanService")
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanDao taiKhoanDao;
    @Autowired
    private JavaMailSender mailSender;
    public void setTaiKhoanDao(TaiKhoanDao taiKhoanDao) {
        this.taiKhoanDao = taiKhoanDao;
    }
    @Override
    public void addTaiKhoan(TaiKhoan taiKhoan){this.taiKhoanDao.addTaiKhoan(taiKhoan);}
    @Override
    public void updateTaiKhoan(TaiKhoan taiKhoan){this.taiKhoanDao.updateTaiKhoan(taiKhoan);}
    @Override
    public void deleteTaiKhoan(String maTaiKhoan){this.taiKhoanDao.deleteTaiKhoan(maTaiKhoan);}
    @Override
    public TaiKhoan getTaiKhoanById(String maTaiKhoan){return this.taiKhoanDao.getTaiKhoanById(maTaiKhoan);}
    @Override
    public TaiKhoan getTaiKhoanByUsername(String username){return this.taiKhoanDao.getTaiKhoanByUsername(username);}
    @Override
    public List<TaiKhoan> getTaiKhoanByTrangThai(boolean trangThai){return this.taiKhoanDao.getTaiKhoanByTrangThai(trangThai);}
    @Override
    public List<TaiKhoan> getAllTaiKhoans(){return this.taiKhoanDao.getAllTaiKhoans();}
    @Override
    public List<String> getAllMaTaiKhoan(){return  this.taiKhoanDao.getAllMaTaiKhoan();}
    @Override
    public String checkLogin(String username,String password){
            TaiKhoan taiKhoanGoc=new TaiKhoan();
        try {
            taiKhoanGoc = this.getTaiKhoanByUsername(username);
        }catch (HibernateException e){
                return "failed";
        }
        try {
            if(BCrypt.checkpw(password,taiKhoanGoc.getPassword())){
                return "success";
            } else {
                return "errorPass";
            }
        } catch(IllegalArgumentException e){
                    return "errorPass";
                }
    }
    @Override
    public void sendEmail(HttpServletRequest request, HttpServletResponse response, String from, String toAddress, String subject, String message) throws IOException, AddressException, MessagingException, ServletException {
        try{
            MimeMessage mimeMessage=this.mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(from, from);
            helper.setTo(toAddress);
            helper.setReplyTo(from, from);
            helper.setSubject(subject);
            helper.setText(message, true);
            this.mailSender.send(mimeMessage);
            request.setAttribute("messageGuiMail", "Gửi email thành công!");
        } catch (Exception ex) {
            request.setAttribute("messageGuiMail", "Gửi email thất bại!:"+ ex.toString());
            request.getRequestDispatcher("/WEB-INF/views/DangKi.jsp").forward(request, response);
        }
    }
    @Override
    public String randomMaTaiKhoan(){
        String randomMaTaiKhoan;
        RandomId randomId = new RandomId();
        List<String> stringList= getAllMaTaiKhoan();
        System.out.println("GetAll phieudat xong");
        do {
            randomMaTaiKhoan = "MTK" + RandomStringUtils.randomNumeric(6);
        }while (!randomId.testId(stringList,randomMaTaiKhoan));
        return  randomMaTaiKhoan;
    }
}
