package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vetauhoa.entity.HanhKhach;
import vetauhoa.entity.TaiKhoan;
import vetauhoa.service.HanhKhachService;
import vetauhoa.service.NhanVienService;
import vetauhoa.service.TaiKhoanService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminTaiKhoanController {
    @Autowired
    HanhKhachService hanhKhachService;
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    NhanVienService nhanVienService;
    @RequestMapping(value = "/tai-khoan",method = RequestMethod.GET)
    public String quanLyTaìKhoan(ModelMap modelMap){
        List<TaiKhoan> taiKhoanList=taiKhoanService.getAllTaiKhoans();
        modelMap.addAttribute("taiKhoanList",taiKhoanList);
        return "QuanLyTaiKhoan";
    }

    //add hanh khach
    @RequestMapping(value ="/tai-khoan/add")
    public String themTaiKhoan(HttpServletRequest request,ModelMap modelMap){
        return "ThemTaiKhoan";
    }
    @RequestMapping(value = "/tai-khoan/add",method = RequestMethod.POST)
    public String addTaiKhoan(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        if(taiKhoanService.getTaiKhoanByUsername(request.getParameter("username")).getMaTaiKhoan()!=null){
            request.setAttribute("message","Tên tài khoản đã tồn tại!");
            return "ThemTaiKhoan";
//            request.getRequestDispatcher("/WEB-INF/views/ThemTaiKhoan").forward(request, response);
        }else {
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setMaTaiKhoan(taiKhoanService.randomMaTaiKhoan());
            String username = request.getParameter("username");
            taiKhoan.setUsername(username);
            String password = request.getParameter("password");
            taiKhoan.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
            String trangThai = request.getParameter("trangThai");
            taiKhoan.setTrangThai(Boolean.parseBoolean(trangThai));
            String role = request.getParameter("role");
            taiKhoan.setRole(role);
            taiKhoanService.addTaiKhoan(taiKhoan);
        }
        return "redirect:/admin/tai-khoan";
    }
    @RequestMapping(value ="/tai-khoan/{maTaiKhoan}/trang-thai",method = RequestMethod.POST)
    public String xoaHanhKhach(@PathVariable("maTaiKhoan")String maTaiKhoan,HttpServletRequest request,HttpServletResponse response){
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanById(maTaiKhoan);
        taiKhoan.setTrangThai(!taiKhoan.isTrangThai());
        taiKhoanService.updateTaiKhoan(taiKhoan);
        return "redirect:/admin/tai-khoan";
    }
    @RequestMapping(value = "/tai-khoan",params = "search", method = RequestMethod.GET)
    public String searchTaiKhoanAdmin(@PathVariable(value = "stringSearch")String stringSearch,HttpServletRequest request,HttpServletResponse response){
        return "QuanLyTaiKhoanAdmin";
    }

}
