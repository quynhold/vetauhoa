package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vetauhoa.entity.*;
import vetauhoa.validator.RandomId;
import vetauhoa.service.*;
import vetauhoa.validator.ThanhToan;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MuaVeController {
    @Autowired
    private PhieuDatService phieuDatService;
    @Autowired
    private HanhKhachService hanhKhachService;
    @Autowired
    private LichTrinhService lichTrinhService;
    @Autowired
    private ChoDatService choDatService;
    @Autowired
    private ToaService toaService;
    @Autowired
    private TauService tauService;
    @Autowired
    private GaService gaService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private VeService veService;
    @Autowired
    private TrangThaiChoDatService trangThaiChoDatService;
    private RandomId randomId;
    private String maGaDenx;
    private String maLichTrinhx;
    private String maChoDatx;
    public List<PhieuDat> phieuDatList=new ArrayList<PhieuDat>();
    public void setLichTrinhService(LichTrinhService lichTrinhService) {
        this.lichTrinhService = lichTrinhService;
    }
    public void setToaService(ToaService toaService) {this.toaService=toaService;}
    private ThanhToan thanhToan;

    @RequestMapping(value = "/{maLichTrinh}/chon-toa" , method =  RequestMethod.GET)
    public String chonToa(@PathVariable(value = "maLichTrinh")String maLichTrinh, HttpServletRequest request,HttpServletResponse response, ModelMap modelMap)throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println(maLichTrinh);
        LichTrinh lichTrinh=this.lichTrinhService.getLichTrinh(maLichTrinh);
        List<Toa> toaList=this.toaService.getToasByTauId(lichTrinh.getTauByMaTau().getMaTau());
        response.addCookie(new Cookie("maLichTrinh",maLichTrinh));
        System.out.println(toaList.isEmpty());
        this.maLichTrinhx=maLichTrinh;
        modelMap.addAttribute("toaList",toaList);
        modelMap.addAttribute("maLichTrinh",maLichTrinh);
        return "ChonToa";
    }

    @RequestMapping(value = "/{maLichTrinh}/{maToa}/chon-cho",method = RequestMethod.GET)
    public String chonCho(@CookieValue(value = "maGaDen")String maGaDen,@PathVariable(value = "maLichTrinh")String maLichTrinh, @PathVariable(value = "maToa")String maToa, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LichTrinh lichTrinh=this.lichTrinhService.getLichTrinh(maLichTrinh);
        Toa toa= toaService.getToaById(maToa);
        this.maGaDenx=maGaDen;
        List<TrangThaiChoDat> trangThaiChoDats=trangThaiChoDatService.getAllTrangThaiByMaLichTrinh(maLichTrinh);
        List<TrangThaiChoDat> trangThaiChoDatsToa=new ArrayList<TrangThaiChoDat>();
        System.out.println("Test chuoi:"+trangThaiChoDats.size());
        for(TrangThaiChoDat trangThaiChoDat:trangThaiChoDats){
            ChoDat choDat=trangThaiChoDat.getChoDatByMaChoDat();
            if(choDat.getToaByMaToa().getMaToa().equals(maToa)) {
                trangThaiChoDatsToa.add(trangThaiChoDat);
            }
        }
        System.out.println("Test chuoi trang thai:"+trangThaiChoDatsToa.isEmpty());
        modelMap.addAttribute("trangThaiChoDatList",trangThaiChoDatsToa);
        modelMap.addAttribute("maLichTrinh",maLichTrinh);
        modelMap.addAttribute("maToa",maToa);
        BigDecimal giaVe=this.giaVe(lichTrinh.getMaLichTrinh(),maGaDen,maToa);
        System.out.println(giaVe);
        modelMap.addAttribute("giaVe",giaVe);
        return "ChonChoDat";
    }

    @RequestMapping(value = "/{maLichTrinh}/{maToa}/{maChoDat}/dat-ve",method = RequestMethod.GET)
    public String bookPage(@PathVariable(value = "maLichTrinh")String maLichTrinh, @PathVariable(value = "maToa")String maToa,
                           @PathVariable(value = "maChoDat")String maChoDat, @CookieValue(value = "maGaDen")String maGaDen,
                           HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        BigDecimal giaVe=giaVe(maLichTrinh,maGaDen,maToa);
        PhieuDat phieuDat=new PhieuDat();
        this.maChoDatx=maChoDat;
        LichTrinh lichTrinh=this.lichTrinhService.getLichTrinh(maLichTrinh);
        response.addCookie(new Cookie("maChoDat",maChoDat));
        modelMap.addAttribute("maTau",lichTrinh.getTauByMaTau().getBienSo());
        modelMap.addAttribute("gaDi",lichTrinh.getGaByMaGaXuatPhat().getTenGa());
        modelMap.addAttribute("gaDen",this.gaService.getGaById(maGaDen).getTenGa());
        modelMap.addAttribute("soChoDat",this.choDatService.getChoDatById(maChoDat).getSoThuTu());
        modelMap.addAttribute("thoiGianXuatPhat",lichTrinh.getThoiGianXuatPhat());
        modelMap.addAttribute("giaVe",giaVe);
        modelMap.addAttribute("phieuDat",phieuDat);
        return "DatVe";
    }
    @RequestMapping(value = "/mua-ve",method = RequestMethod.POST)
    public String addPhieuDat(@CookieValue(value = "maGaDen")String maGaDen,
                                    HttpServletRequest request,HttpServletResponse response,
                                    ModelMap modelMap)throws IOException{
        System.out.println("Add test lennh wtf");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String maLichTrinh=this.maLichTrinhx;
        String maChoDat=this.maChoDatx;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        TrangThaiChoDat trangThaiChoDat=new TrangThaiChoDat();
        trangThaiChoDat=trangThaiChoDatService.getTrangThaiByMaLTCD(maLichTrinh,maChoDat);
        if(trangThaiChoDat==null){
            System.out.println("Trang thai cho dat ==null");
        }
        System.out.println("Check 1:"+ trangThaiChoDat.getTrangThai());
        trangThaiChoDat.setTrangThai("D");
        System.out.println(trangThaiChoDat.getMaTrangThai());
        trangThaiChoDatService.updateTrangThai(trangThaiChoDat);
        System.out.println("Update trang thai cho dat xong");
        HanhKhach hanhKhach=new HanhKhach();
        if(hanhKhachService.checkCccd(request.getParameter("CCCD"))){
            hanhKhach=hanhKhachService.getHanhKhachsByCccd(request.getParameter("CCCD"));
            System.out.println("Tim thay hanh khach ton tai roi ne:)");
        }else {
            hanhKhach.setMaHanhKhach(hanhKhachService.randomMaHanhKhach());
            hanhKhach.setCccd(request.getParameter("CCCD"));
        }
        System.out.println("Check hk ton tai:"+hanhKhachService.checkCccd(request.getParameter("CCCD")));
        hanhKhach.setHo(request.getParameter("ho"));
        hanhKhach.setTen(request.getParameter("ten"));
        if(hanhKhach.getEmail()==null) {
            hanhKhach.setEmail(request.getParameter("email"));
        }
        if(hanhKhach.getSdt()==null) {
            hanhKhach.setSdt(request.getParameter("sdt"));
        }
        ChoDat choDat=choDatService.getChoDatById(maChoDat);
        BigDecimal giaVe=giaVe(maLichTrinh,maGaDen,choDat.getToaByMaToa().getMaToa());
        PhieuDat phieuDat=new PhieuDat();
        LichTrinh lichTrinh=this.lichTrinhService.getLichTrinh(maLichTrinh);
        phieuDat.setMaPhieuDat(this.phieuDatService.randomMaPhieuDat());
        phieuDat.setHanhKhachByMaHanhKhach(hanhKhach);
        phieuDat.setLichTrinhByMaLichTrinh(this.lichTrinhService.getLichTrinh(maLichTrinh));
        phieuDat.setGaByMaGaDen(this.gaService.getGaById(maGaDen));
        phieuDat.setChoDatByMaChoDat(this.choDatService.getChoDatById(maChoDat));
        phieuDat.setThoiGianDat(Timestamp.valueOf(now));
        HoaDon hoaDon=new HoaDon();
        hoaDon.setMaHoaDon(this.hoaDonService.randomMaHoaDon());
        hoaDon.setHinhThucThanhToan(request.getParameter("hinhThucThanhToan"));
        hoaDonService.addHoaDon(hoaDon);
        phieuDat.setHoaDonByMaHoaDon(hoaDonService.getHoaDon(hoaDon.getMaHoaDon()));
        hanhKhachService.addHanhKhach(hanhKhach);
        System.out.println("Add Hanh Khach xong");
        phieuDatService.addPhieuDat(phieuDat);
        System.out.println("Add phieu dat xong");
        Ve ve=new Ve();
        ve.setMaVe(phieuDat.getMaPhieuDat().substring(0,4)+maChoDat.substring(1));
        ve.setPhieuDatByMaPhieuDat(this.phieuDatService.getPhieuDatById(phieuDat.getMaPhieuDat()));
        veService.addVe(ve);
        System.out.println("Add ve thanh cong");
        modelMap.addAttribute("phieuDat",phieuDat);
        modelMap.addAttribute("hoaDon",hoaDon);
        modelMap.addAttribute("hanhKhach",hanhKhach);
        modelMap.addAttribute("lichTrinh",lichTrinh);
        modelMap.addAttribute("ve",ve);
        return "DatVeThanhCong";
    }



public BigDecimal giaVe(String maLichTrinh, String maGaDen, String maToa){
    BigDecimal giaVe;
    BigDecimal giaMoiDonVi=new BigDecimal(800);
    LichTrinh lichTrinh=this.lichTrinhService.getLichTrinh(maLichTrinh);
    Ga gaden=gaService.getGaById(maGaDen);
    Toa toa=toaService.getToaById(maToa);
    String loaiToa=toa.getLoaiCho();
    if(loaiToa.equals("Ngoi")){
        giaVe=lichTrinh.getGiaMoCua().add(giaMoiDonVi.multiply(BigDecimal.valueOf(Math.abs(lichTrinh.getGaByMaGaXuatPhat().getKhoangCach()-gaden.getKhoangCach()))));
    }else{
        giaVe=lichTrinh.getGiaMoCua().add(giaMoiDonVi.multiply(BigDecimal.valueOf(Math.abs(lichTrinh.getGaByMaGaXuatPhat().getKhoangCach()-gaden.getKhoangCach())))).multiply(BigDecimal.valueOf(1.2));
    }
    return  giaVe;
}
}
