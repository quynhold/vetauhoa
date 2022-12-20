package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vetauhoa.entity.HanhKhach;
import vetauhoa.entity.TaiKhoan;
import vetauhoa.service.HanhKhachService;
import vetauhoa.service.TaiKhoanService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminKhachHangController {
    @Autowired
    HanhKhachService hanhKhachService;
    @Autowired
//            Get
    TaiKhoanService taiKhoanService;
    @RequestMapping(value = "/hanh-khach",method = RequestMethod.GET)
    public String quanLyHanhKhach(ModelMap modelMap){
        List<HanhKhach> hanhKhachList=hanhKhachService.getAllHanhKhachs();
        modelMap.addAttribute("hanhKhachList",hanhKhachList);
        return "QuanLyHanhKhach";
    }

    //add hanh khach
    @RequestMapping(value ="/hanh-khach/add")
    public String themHanhKhach(HttpServletRequest request,ModelMap modelMap){
        return "ThemHanhKhach";
    }
    @RequestMapping(value = "/hanh-khach/add",method = RequestMethod.POST)
    public String addHanhKhach(HttpServletRequest request, HttpServletResponse response){
        HanhKhach hanhKhach=new HanhKhach();
        hanhKhach.setMaHanhKhach(hanhKhachService.randomMaHanhKhach());
        String ho=request.getParameter("ho");
        hanhKhach.setHo(ho);
        String ten=request.getParameter("ten");
        hanhKhach.setTen(ten);
        String cccd=request.getParameter("cccd");
        hanhKhach.setCccd(cccd);
        String ngaySinh=request.getParameter("ngaySinh");
        hanhKhach.setNgaySinh(Date.valueOf(ngaySinh));
        String gioiTinh=request.getParameter("gioiTinh");
        hanhKhach.setGioiTinh(gioiTinh);
        String std=request.getParameter("sdt");
        hanhKhach.setSdt(std);
        String email=request.getParameter("email");
        hanhKhach.setEmail(email);
        String diaChi=request.getParameter("diaChi");
        hanhKhach.setDiaChi(diaChi);
        hanhKhachService.addHanhKhach(hanhKhach);
        return "redirect:/admin/hanh-khach";
    }
    @RequestMapping(value ="/hanh-khach/{maHanhKhach}/delete")
    public String xoaHanhKhach(@PathVariable(value = "maHanhKhach")String maHanhKhach,HttpServletRequest request,HttpServletResponse response){
        hanhKhachService.deleteHanhKhach(maHanhKhach);
        return "redirect:/admin/hanh-khach";
    }
    //Edit
    @RequestMapping(value = "/hanh-khach/{maHanhKhach}/edit")
    public String editHanhKhach(@PathVariable(value = "maHanhKhach")String maHanhKhach,HttpServletResponse response,HttpServletRequest request,ModelMap modelMap){
        modelMap.addAttribute("hanhKhach",hanhKhachService.getHanhKhachById(maHanhKhach));
        return "EditHanhKhach";
    }
    @RequestMapping(value = "/hanh-khach",method = RequestMethod.POST)
    public String editHanhKhachBt(HttpServletRequest request,HttpServletResponse response){
        HanhKhach hanhKhach=new HanhKhach();
        String maHanhKhach=request.getParameter("maHanhKhach");
        hanhKhach=hanhKhachService.getHanhKhachById(maHanhKhach);
        String ho=request.getParameter("ho");
        hanhKhach.setHo(ho);
        String ten=request.getParameter("ten");
        hanhKhach.setTen(ten);
        String cccd=request.getParameter("cccd");
        hanhKhach.setCccd(cccd);
        String ngaySinh=request.getParameter("ngaySinh");
        hanhKhach.setNgaySinh(Date.valueOf(ngaySinh));
        String gioiTinh=request.getParameter("gioiTinh");
        hanhKhach.setGioiTinh(gioiTinh);
        String std=request.getParameter("sdt");
        hanhKhach.setSdt(std);
        String email=request.getParameter("email");
        hanhKhach.setEmail(email);
        String diaChi=request.getParameter("diaChi");
        hanhKhach.setDiaChi(diaChi);
        hanhKhachService.updateHanhKhach(hanhKhach);
        return "redirect:/admin/hanh-khach";
    }
    @RequestMapping(value = "/hanh-khach",params = "search", method = RequestMethod.GET)
    public String searchHanhKhach(@PathVariable(value = "stringSearch")String stringSearch,HttpServletRequest request,HttpServletResponse response){
        return "QuanLyHanhKhach";
    }

}
