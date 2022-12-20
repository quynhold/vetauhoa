package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import javax.ws.rs.core.SecurityContext;
import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.net.Authenticator;
import java.util.Collection;

@Controller
public class LoginController {
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    HanhKhachService hanhKhachService;
    @Autowired
    NhanVienService nhanVienService;
    @RequestMapping(value = "/dang-nhap",method = RequestMethod.GET)
    public String dangNhap(){
        return "DangNhap";
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        Collection<SimpleGrantedAuthority> authority=(Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
        String role=authority.toString();
        request.setAttribute("role",role);
        if(role.equals("ROLE_ADMIN")){
            return "redirect:/admin/hanh-khach";
        }else if(role.equals("ROLE_USER")){
            return "redirect:/trang-chu";
        }else{
            return "redirect:/dang-nhap?error=failed";
        }
    }
    @RequestMapping(value = "/dang-xuat",method = RequestMethod.GET)
    public String dangXuat(HttpServletRequest request,HttpServletResponse response){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/dang-nhap";
    }
}

