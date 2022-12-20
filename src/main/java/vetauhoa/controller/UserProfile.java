package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import vetauhoa.entity.HanhKhach;
import vetauhoa.entity.NhanVien;
import vetauhoa.entity.TaiKhoan;
import vetauhoa.service.HanhKhachService;
import vetauhoa.service.TaiKhoanService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@Controller
@RequestMapping(value = "/user")
public class UserProfile {
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    HanhKhachService hanhKhachService;
    @RequestMapping(value="/thong-tin-tai-khoan",method = RequestMethod.GET)
    public String inforNhanVien(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        System.out.println("Check user "+username);
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanByUsername(username);
        System.out.println("Check tai khoan "+taiKhoan.getMaTaiKhoan());
        HanhKhach hanhKhach =hanhKhachService.getHanhKhachsByTaiKhoanId(taiKhoan.getMaTaiKhoan());
        System.out.println("Check hanh khach "+hanhKhach.getMaHanhKhach());
        modelMap.addAttribute("taiKhoan",taiKhoan);
        modelMap.addAttribute("hanhKhach",hanhKhach);
        return "ThongTinTaiKhoanUser";
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
        return "redirect:/user/thong-tin-tai-khoan";
    }
    @RequestMapping(value = "/edit-profile",method = RequestMethod.GET)
    public String editProfile(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException{
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        System.out.println("Check user"+username);
        TaiKhoan taiKhoan=taiKhoanService.getTaiKhoanByUsername(username);
        System.out.println("Check TK: "+taiKhoan.getMaTaiKhoan());
        HanhKhach hanhKhach =hanhKhachService.getHanhKhachsByTaiKhoanId(taiKhoan.getMaTaiKhoan());
        System.out.println("Check HK:"+hanhKhach.getMaHanhKhach());
        modelMap.addAttribute("taiKhoan",taiKhoan);
        modelMap.addAttribute("hanhKhach",hanhKhach);
        return "EditHanhKhachProfile";
    }
    @RequestMapping(value = "/edit-profile",method = RequestMethod.POST)
    public String editHanhKhachProfile(HttpServletRequest request,HttpServletResponse response){
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
        return "redirect:/user/thong-tin-tai-khoan";
    }
}
