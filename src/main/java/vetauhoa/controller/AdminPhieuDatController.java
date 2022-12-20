package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vetauhoa.entity.*;
import vetauhoa.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminPhieuDatController {
    @Autowired
    PhieuDatService phieuDatService;
    @Autowired
    LichTrinhService lichTrinhService;
    @Autowired
    GaService gaService;
    @Autowired
    TauService tauService;
    @RequestMapping(value = "/phieu-dat",method = RequestMethod.GET)
    public String quanLyPhieuDat(ModelMap modelMap){
        List<PhieuDat> phieuDatList=phieuDatService.getAllPhieuDat();
        modelMap.addAttribute("phieuDatList",phieuDatList);
        return "QuanLyPhieuDat";
    }

//    @RequestMapping(value ="/phieu-dat",params = "xoa")
//    public String xoaPhieuDat(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
//        String maPhieuDat=request.getParameter("maLichTrinh");
//        phieuDatService.deletePhieuDat(maPhieuDat);
//        return "QuanLyPhieuDat";
//    }
//    //Edit
//    @RequestMapping(value = "/phieu-dat",params = "edit")
//    public String editPhieuDat(@ModelAttribute("phieuDat")PhieuDat phieuDat,HttpServletResponse response,HttpServletRequest request,ModelMap modelMap){
//        modelMap.addAttribute("phieuDat",phieuDat);
//        return "EditPhieuDat";
//    }
//    @RequestMapping(value = "/phieu-dat",method = RequestMethod.POST)
//    public String editPhieuDatBt(@ModelAttribute("phieuDat")PhieuDat phieuDat, HttpServletRequest request,HttpServletResponse response){ ;
//        String maLichTrinh=request.getParameter("maLichTrinh");
//        phieuDat.setLichTrinhByMaLichTrinh(lichTrinhService.getLichTrinh(maLichTrinh));
//
//        return "QuanLyHanhKhach";
//    }
//    @RequestMapping(value = "/phieu-dat",params = "search", method = RequestMethod.GET)
//    public String searchPhieuDat(@PathVariable(value = "stringSearch")String stringSearch,HttpServletRequest request,HttpServletResponse response){
//        return "QuanLyPhieuDat";
//    }

}
