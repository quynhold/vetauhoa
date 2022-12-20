package vetauhoa.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import vetauhoa.entity.HanhKhach;
import vetauhoa.entity.NhanVien;
import vetauhoa.entity.TaiKhoan;
import vetauhoa.service.HanhKhachService;
import vetauhoa.service.NhanVienService;
import vetauhoa.service.TaiKhoanService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

@Controller
public class RegisterController {
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    HanhKhachService hanhKhachService;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    JavaMailSender javaMailSender;

    File file=new File("C:/Users/huydnd/IdeaProjects/vetauhoa/src/main/webapp/resources/img/avatar.png");

    @RequestMapping(value = "/dang-ki")
    public String dangKiForm(HttpServletResponse response, HttpServletRequest request){
        return "DangKi";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("sessionuser") != null || session.getAttribute("sessionadmin") != null) {
            request.getRequestDispatcher("HomeController").forward(request, response);
        } else {
            request.getRequestDispatcher("/dang-ki").forward(request, response);
        }
    }
    @RequestMapping(value ="/verify",method = RequestMethod.POST)
    public String dangKiTaiKhoan(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String ho = request.getParameter("ho");
        String ten =request.getParameter("ten");
        String cccd=request.getParameter("cccd");
        String usernameReg = request.getParameter("username");
        String passwordReg = request.getParameter("password");
        String passwordHash = BCrypt.hashpw(passwordReg, BCrypt.gensalt()); // mã hóa thành hàm băm
        String emailReg = request.getParameter("email");
        request.setAttribute("username",usernameReg);
        if (taiKhoanService.getTaiKhoanByUsername(usernameReg)==null) {
            if(nhanVienService.checkEmail(emailReg)||hanhKhachService.checkEmail(emailReg)){
                request.setAttribute("message","Email đã được sử dụng, vui lòng dùng email khác.");
                request.getRequestDispatcher("/dang-ki").forward(request, response);
            }else {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setMaTaiKhoan(taiKhoanService.randomMaTaiKhoan());
                taiKhoan.setPassword(passwordHash);
                taiKhoan.setUsername(usernameReg);
                taiKhoan.setTrangThai(false);
                taiKhoan.setRole("USER");
                taiKhoan.setAvatar(FileUtils.readFileToByteArray(file));
                taiKhoan.setVerifyCode(RandomStringUtils.randomAlphanumeric(6));
                HanhKhach hanhKhach=new HanhKhach();
                hanhKhach.setMaHanhKhach(hanhKhachService.randomMaHanhKhach());
                hanhKhach.setCccd(cccd);
                hanhKhach.setHo(ho);
                hanhKhach.setTen(ten);
                hanhKhach.setEmail(emailReg);
                hanhKhach.setTaiKhoanByMaTaiKhoan(taiKhoan);
                try {
                    String from="vetauhoa.cskh@gmail.com";
                    try {
                        taiKhoanService.sendEmail(request, response, from, emailReg, "Verify Account", taiKhoan.getVerifyCode());
                    }catch (Exception e){
                        request.setAttribute("message","Gửi mail thất bại!");
                        request.getRequestDispatcher("/dang-ki").forward(request, response);
                    }
                    taiKhoanService.addTaiKhoan(taiKhoan);
                    hanhKhachService.addHanhKhach(hanhKhach);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", "Lỗi hệ thống!");
                    request.getRequestDispatcher("/dang-ki").forward(request, response);
                }
            }
        }else {
            request.setAttribute("message","Tên người dùng đã tồn tại.");
            request.getRequestDispatcher("/dang-ki").forward(request, response);
        }
        return "Verify";
    }
    @RequestMapping(value = "/{username}/confirm-verify",method = RequestMethod.GET)
    public String verify(@PathVariable("username")String username, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("verify-code"));
        String code=request.getParameter("verify-code");
        if(taiKhoanService.getTaiKhoanByUsername(username).getVerifyCode().equals(code)){
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanByUsername(username);
        taiKhoan.setTrangThai(true);
        taiKhoanService.updateTaiKhoan(taiKhoan);
        System.out.println("Kích hoạt tài khoản thành công");
        return "redirect:/dang-nhap";
        }else{
            request.setAttribute("message","Mã kích hoạt không đúng" );
            return "redirect:/{username}/confirm-verify";
        }
    }
    @RequestMapping(value = "/quen-password",method = RequestMethod.GET)
    public String quenPW(HttpServletRequest request,HttpServletResponse response){
        return "QuenPassword";
    }
    @RequestMapping(value = "/quen-password",method = RequestMethod.POST)
    public String quenPWPost(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        if(email.isEmpty()) {
            if (username.isEmpty()) {
                request.setAttribute("message", "Không được để trống thông tin!");
                return "QuenPassword";
            }
            HanhKhach hanhKhach = hanhKhachService.getHanhKhachsByTaiKhoanId(taiKhoanService.getTaiKhoanByUsername(username).getMaTaiKhoan());
            email =hanhKhach.getEmail();
        }
        if(username.isEmpty()){
            username=hanhKhachService.getHanhKhachsByEmail(email).getTaiKhoanByMaTaiKhoan().getUsername();
        }
            String verifyCode=RandomStringUtils.randomAlphanumeric(6);
        System.out.println("Code check mowi ne :>");
        TaiKhoan taiKhoan= taiKhoanService.getTaiKhoanByUsername(username);
        taiKhoan.setVerifyCode(verifyCode);
        System.out.println("Check Code: "+taiKhoan.getVerifyCode());
        taiKhoanService.updateTaiKhoan(taiKhoan);
            try {
                String from="vetauhoa.cskh@gmail.com";
                try {
                    taiKhoanService.sendEmail(request, response, from, email, "Quên mật khẩu", verifyCode);
                }catch (Exception e){
                    request.setAttribute("message","Gửi mail thất bại!");
                    return "QuenPassword";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                request.setAttribute("message", "Lỗi hệ thống!");
                return "QuenPassword";
            }
        modelMap.addAttribute("username",username);
        return "CheckCodeFP";
    }
    @RequestMapping(value = "/{username}/change-password",method = RequestMethod.POST)
    public String verifyMail(@PathVariable("username")String username, HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) throws ServletException, IOException {
        System.out.println("Ma code ne:" +request.getParameter("verify-code"));
        String code=request.getParameter("verify-code");
        if(taiKhoanService.getTaiKhoanByUsername(username).getVerifyCode().equals(code)){
            System.out.println("Check dung cmnr con loi a?");
            return "ChangePassword";
        }
            request.setAttribute("message","Mã kích hoạt không đúng" );
            modelMap.addAttribute("username",username);
            return "CheckCodeFP";
    }
    @RequestMapping(value= "/{username}/save-password",method = RequestMethod.POST)
    public String ChangePassword(@PathVariable("username")String username, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String passwordReg = request.getParameter("password");
        String passwordHash = BCrypt.hashpw(passwordReg, BCrypt.gensalt());
        TaiKhoan taiKhoan= taiKhoanService.getTaiKhoanByUsername(username);
        taiKhoan.setPassword(passwordHash);
        taiKhoanService.updateTaiKhoan(taiKhoan);
        return "redirect:/trang-chu";
    }
}
