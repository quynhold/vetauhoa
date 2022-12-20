package vetauhoa.controller;

import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import vetauhoa.entity.HanhKhach;
import vetauhoa.entity.NhanVien;
import vetauhoa.entity.TaiKhoan;
import vetauhoa.service.NhanVienService;
import vetauhoa.service.TaiKhoanService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminNhanVienController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
//            Get
    TaiKhoanService taiKhoanService;
    @RequestMapping(value = "/nhan-vien",method = RequestMethod.GET)
    public String quanLyNhanVien(ModelMap modelMap){
        List<NhanVien> nhanVienList=nhanVienService.getAllNhanViens();
        modelMap.addAttribute("nhanVienList",nhanVienList);
        return "QuanLyNhanVien";
    }

    //add hanh khach
    @RequestMapping(value ="/nhan-vien/add")
    public String themNhanVien(HttpServletRequest request,ModelMap modelMap){
        return "ThemNhanVien";
    }
    @RequestMapping(value = "/nhan-vien/add",method = RequestMethod.POST)
    public String addNhanVien(HttpServletRequest request, HttpServletResponse response){
        NhanVien nhanVien=new NhanVien();
        nhanVien.setMaNhanVien(nhanVienService.randomMaNhanVien());
        String ho=request.getParameter("ho");
        nhanVien.setHo(ho);
        String ten=request.getParameter("ten");
        nhanVien.setTen(ten);
        String ngaySinh=request.getParameter("ngaySinh");
        nhanVien.setNgaySinh(Date.valueOf(ngaySinh));
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/admin/nhan-vien";
    }
    //Edit
    @RequestMapping(value = "/nhan-vien/{maNhanVien}/edit")
    public String editNhanVien(@PathVariable("maNhanVien")String maNhanVien,HttpServletResponse response,HttpServletRequest request,ModelMap modelMap){
        NhanVien nhanVien=nhanVienService.getNhanVienById(maNhanVien);
        modelMap.addAttribute("nhanVien",nhanVien);
        return "EditNhanVien";
    }
    @RequestMapping(value = "/nhan-vien",method = RequestMethod.POST)
    public String editNhanVienBt(HttpServletRequest request,HttpServletResponse response){
        NhanVien nhanVien=new NhanVien();
        String maNhanVien=request.getParameter("maNhanVien");
        nhanVien=nhanVienService.getNhanVienById(maNhanVien);
        nhanVien.setHo(request.getParameter("ho"));
        nhanVien.setTen(request.getParameter("ten"));
        nhanVien.setNgaySinh(Date.valueOf(request.getParameter("ngaySinh")));
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/admin/nhan-vien";
    }
    @RequestMapping(value = "/nhan-vien",params = "search", method = RequestMethod.GET)
    public String searchNhanVien(@PathVariable(value = "stringSearch")String stringSearch,HttpServletRequest request,HttpServletResponse response){
        return "QuanLyNhanVien";
    }
    @RequestMapping(value="/thong-tin-tai-khoan",method = RequestMethod.GET)
    public String inforNhanVien(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanByUsername(username);
        NhanVien nhanVien=nhanVienService.getNhanViensByTaiKhoanId(taiKhoan.getMaTaiKhoan());
        modelMap.addAttribute("taiKhoan",taiKhoan);
        modelMap.addAttribute("nhanVien",nhanVien);
        return "ThongTinTaiKhoanAdmin";
    }
    @RequestMapping(value = "/edit-profile",method = RequestMethod.GET)
    public String editNVProfile(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException{
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        System.out.println("Check user"+username);
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanByUsername(username);
        System.out.println("Check TK: "+taiKhoan.getMaTaiKhoan());
        NhanVien nhanVien=nhanVienService.getNhanViensByTaiKhoanId(taiKhoan.getMaTaiKhoan());
        modelMap.addAttribute("taiKhoan",taiKhoan);
        modelMap.addAttribute("nhanVien",nhanVien);
        return "EditNhanVienProfile";
    }
    @RequestMapping(value = "/edit-profile",method = RequestMethod.POST)
    public String editNhanVienProfile(HttpServletRequest request,HttpServletResponse response){
        NhanVien nhanVien=new NhanVien();
        String maNhanVien=request.getParameter("maNhanVien");
        nhanVien=nhanVienService.getNhanVienById(maNhanVien);
        nhanVien.setHo(request.getParameter("ho"));
        nhanVien.setTen(request.getParameter("ten"));
        nhanVien.setNgaySinh(Date.valueOf(request.getParameter("ngaySinh")));
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/admin/thong-tin-tai-khoan";
    }
    @RequestMapping(value = "/uploadAvatar",method = RequestMethod.POST)
    public String updateAvatar(MultipartHttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanByUsername(username);
        MultipartFile avatar= request.getFile("avatar");
        if(avatar.isEmpty()==false && (avatar.getContentType().equals("image/jpeg")||avatar.getContentType().equals("image/png")||avatar.getContentType().equals("image/gif"))) {
            taiKhoan.setAvatar(avatar.getBytes());
            System.out.println("\n\ntrue\n\n");
        }
        else {
            request.setAttribute("error","Kích thước ảnh quá lớn");
        }
        taiKhoanService.updateTaiKhoan(taiKhoan);
        return "redirect:/admin/thong-tin-tai-khoan";
    }
}
