package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vetauhoa.entity.HanhKhach;
import vetauhoa.entity.NhanVien;
import vetauhoa.entity.TaiKhoan;
import vetauhoa.service.HanhKhachService;
import vetauhoa.service.TaiKhoanService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "/user")
public class UserTaiKhoanController {
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    HanhKhachService hanhKhachService;
    @RequestMapping(value="/thong-tin-tai-khoan",method = RequestMethod.GET)
    public String inforNhanVien(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanByUsername(username);
        HanhKhach hanhKhach=hanhKhachService.getHanhKhachsByTaiKhoanId(taiKhoan.getMaTaiKhoan());
        modelMap.addAttribute("taiKhoan",taiKhoan);
        modelMap.addAttribute("hanhKhach",hanhKhach);
        return "ThongTinTaiKhoanUser";
    }
}
