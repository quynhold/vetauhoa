package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vetauhoa.entity.*;
import vetauhoa.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminLichTrinhController {
    @Autowired
    LichTrinhService lichTrinhService;
    @Autowired
    GaService gaService;
    @Autowired
    TauService tauService;
    @Autowired
    ToaService toaService;
    @Autowired
    TrangThaiChoDatService trangThaiChoDatService;
    @Autowired
    ChoDatService choDatService;
    @RequestMapping(value = "/lich-trinh",method = RequestMethod.GET)
    public String quanLyLichTrinh(ModelMap modelMap){
        List<LichTrinh> lichTrinhList=lichTrinhService.getAllLichTrinhs();
        modelMap.addAttribute("lichTrinhList",lichTrinhList);
        return "QuanLyLichTrinh";
    }

    //add hanh khach
    @RequestMapping(value ="/lich-trinh/add")
    public String themLichTrinh(HttpServletRequest request,ModelMap modelMap){
        List<Tau> tauList=tauService.getAllTaus();
        List<Ga> gaList=gaService.getAllGas();
        modelMap.addAttribute("tauList",tauList);
        modelMap.addAttribute("gaList",gaList);
        return "ThemLichTrinh";
    }
    @RequestMapping(value = "/lich-trinh/add",method = RequestMethod.POST)
    public String addLichTrinh(HttpServletRequest request, HttpServletResponse response){
        LichTrinh lichTrinh=new LichTrinh();
        lichTrinh.setMaLichTrinh(lichTrinhService.randomMaLichTrinh());
        String maTau=request.getParameter("maTau");
        lichTrinh.setTauByMaTau(tauService.getTauById(maTau));
        String gaXuatPhat=request.getParameter("maGaXuatPhat");
        lichTrinh.setGaByMaGaXuatPhat(gaService.getGaById(gaXuatPhat));
        String gaCuoi=request.getParameter("maGaCuoi");
        lichTrinh.setGaByMaGaCuoi(gaService.getGaById(gaCuoi));
        String ngayXuatPhat=request.getParameter("ngayXuatPhat");
        System.out.println("day ne: "+ngayXuatPhat);
        String gioXuatPhat=request.getParameter("gioXuatPhat");
        System.out.println("time ne: "+gioXuatPhat);
//        System.out.println("date ne: "+date);
        String time= gioXuatPhat+":00";
        System.out.println("time ne: "+time);
        String timeStamp=ngayXuatPhat+' '+time;
        System.out.println("ne: "+timeStamp);
        Timestamp timestamps=Timestamp.valueOf(timeStamp);
        lichTrinh.setThoiGianXuatPhat(timestamps);
        String giaMoCua=request.getParameter("giaMoCua");
        BigDecimal gia=BigDecimal.valueOf(Long.valueOf(giaMoCua));
        lichTrinh.setGiaMoCua(gia);
        lichTrinhService.addLichTrinh(lichTrinh);
        List<ChoDat> choDats=choDatService.getChoDatsByTauId(maTau);
        System.out.println("Test add cho dat");
        System.out.println(choDats.isEmpty());
        TrangThaiChoDat trangThaiChoDat=new TrangThaiChoDat();
        for(ChoDat choDat : choDats){
            trangThaiChoDat.setMaTrangThai(lichTrinh.getMaLichTrinh().substring(3).concat(choDat.getMaChoDat().substring(1)));
            trangThaiChoDat.setChoDatByMaChoDat(choDat);
            trangThaiChoDat.setLichTrinhByMaLichTrinh(lichTrinh);
            trangThaiChoDat.setTrangThai("C");
            trangThaiChoDatService.addTrangThai(trangThaiChoDat);
        }
        return "redirect:/admin/lich-trinh";
    }
    //Edit
    @RequestMapping(value = "/lich-trinh/{maLichTrinh}/edit",method = RequestMethod.GET)
    public String editLichTrinh(@PathVariable("maLichTrinh")String maLichTrinh,HttpServletResponse response,HttpServletRequest request,ModelMap modelMap){
        LichTrinh lichTrinh = lichTrinhService.getLichTrinh(maLichTrinh);
        modelMap.addAttribute("lichTrinh", lichTrinh);
        List<Tau> tauList=tauService.getAllTaus();
        List<Ga> gaList=gaService.getAllGas();
        modelMap.addAttribute("tauList",tauList);
        modelMap.addAttribute("gaList",gaList);
        return "EditLichTrinh";
    }
    @RequestMapping(value = "/lich-trinh/{maLichTrinh}/edit",method = RequestMethod.POST)
    public String editLichTrinhBt(@PathVariable("maLichTrinh")String maLichTrinh,HttpServletRequest request,HttpServletResponse response){ ;
        LichTrinh lichTrinh=new LichTrinh();
        lichTrinh=lichTrinhService.getLichTrinh(maLichTrinh);
        String maTau=request.getParameter("maTau");
        lichTrinh.setTauByMaTau(tauService.getTauById(maTau));
        String gaXuatPhat=request.getParameter("maGaXuatPhat");

        lichTrinh.setGaByMaGaXuatPhat(gaService.getGaById(gaXuatPhat));
        String gaCuoi=request.getParameter("maGaCuoi");
        System.out.println("MaGaEdit:"+ gaXuatPhat +" "+ gaCuoi);
        lichTrinh.setGaByMaGaCuoi(gaService.getGaById(gaCuoi));
        String ngayXuatPhat=request.getParameter("ngayXuatPhat");
        System.out.println("day ne: "+ngayXuatPhat);
        String gioXuatPhat=request.getParameter("gioXuatPhat");
        System.out.println("time ne: "+gioXuatPhat);
//        System.out.println("date ne: "+date);
        String time= gioXuatPhat+":00";
        System.out.println("time ne: "+time);
        String timeStamp=ngayXuatPhat+' '+time;
        System.out.println("ne: "+timeStamp);;
        Timestamp timestamps=Timestamp.valueOf(timeStamp);
        lichTrinh.setThoiGianXuatPhat(timestamps);
        String giaMoCua=request.getParameter("giaMoCua");
        BigDecimal gia=BigDecimal.valueOf(Double.parseDouble(giaMoCua));
        lichTrinh.setGiaMoCua(gia);
        lichTrinhService.updateLichTrinh(lichTrinh);
        return "redirect:/admin/lich-trinh";
    }
    @RequestMapping(value = "/licht-trinh",params = "search", method = RequestMethod.GET)
    public String searchLichTirnh(@PathVariable(value = "stringSearch")String stringSearch,HttpServletRequest request,HttpServletResponse response){
        return "QuanLyLichTrinh";
    }

}
