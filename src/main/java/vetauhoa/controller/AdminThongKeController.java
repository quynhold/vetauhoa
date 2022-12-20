package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vetauhoa.entity.*;
import vetauhoa.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminThongKeController {
    @Autowired
    ChoDatService choDatService;
    @Autowired
    HanhKhachService hanhKhachService;
    @Autowired
    LichTrinhService lichTrinhService;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    GaService gaService;
    @Autowired
    ToaService toaService;
    @Autowired
    TauService tauService;
    @Autowired
    VeService veService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    TrangThaiChoDatService trangThaiChoDatService;
    @Autowired
    PhieuDatService phieuDatService;
    public class ThongKeLichTrinh{
        private LichTrinh lichTrinh;
        private BigDecimal doanhThu;

        public LichTrinh getLichTrinh() {
            return lichTrinh;
        }

        public void setLichTrinh(LichTrinh lichTrinh) {
            this.lichTrinh = lichTrinh;
        }

        public BigDecimal getDoanhThu() {
            return doanhThu;
        }

        public void setDoanhThu(BigDecimal doanhThu) {
            this.doanhThu = doanhThu;
        }

        public ThongKeLichTrinh() {
        }

        public ThongKeLichTrinh(LichTrinh lichTrinh, BigDecimal doanhThu) {
            this.lichTrinh = lichTrinh;
            this.doanhThu = doanhThu;
        }
    }
    public ThongKeLichTrinh getDoanhThuByLichTrinh(LichTrinh lichTrinh){
        ThongKeLichTrinh thongKeLichTrinh=new ThongKeLichTrinh();
        thongKeLichTrinh.setLichTrinh(lichTrinh);
        List<PhieuDat> phieuDatList=phieuDatService.getPhieuDatsByLichTrinhId(lichTrinh.getMaLichTrinh());
        System.out.println("So luong phieu dat cho dat cua lich trinh "+lichTrinh.getMaLichTrinh()+":"+ phieuDatList.size());
        double doanhThu=0;
        if(phieuDatList.size()>=0)
        for(PhieuDat phieuDat : phieuDatList){
            double giave=giaVe(lichTrinh.getMaLichTrinh(),phieuDat.getGaByMaGaDen().getMaGa(),phieuDat.getChoDatByMaChoDat().getToaByMaToa().getMaToa()).doubleValue();
            doanhThu+=giave;
            System.out.println("Gia ve: "+giaVe(lichTrinh.getMaLichTrinh(),phieuDat.getGaByMaGaDen().getMaGa(),phieuDat.getChoDatByMaChoDat().getToaByMaToa().getMaToa()));
            System.out.flush();
            System.out.println("Doanh thu CT:"+ doanhThu);
        }
        BigDecimal doanhThux=BigDecimal.valueOf(doanhThu);
        thongKeLichTrinh.setDoanhThu(doanhThux);
        System.out.println("Doanh thu="+doanhThux);
        return thongKeLichTrinh;
    }
    @RequestMapping(value = "/thong-ke",method = RequestMethod.GET)
    public String quanLyPage(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        List<ChoDat> choDatList=choDatService.getAllChoDats();
        modelMap.addAttribute("choDatList",choDatList);
        List<Tau> tauList=tauService.getAllTaus();
        modelMap.addAttribute("tauList",tauList);
        List<HanhKhach> hanhKhachList = hanhKhachService.getAllHanhKhachs();
        modelMap.addAttribute("hanhKhachList",hanhKhachList);
        List<Toa> toaList=toaService.getAllToas();
        modelMap.addAttribute("toaList",toaList);
        List<PhieuDat> phieuDatList=phieuDatService.getAllPhieuDat();
        modelMap.addAttribute("phieuDatList",phieuDatList);
        List<LichTrinh> lichTrinhList=lichTrinhService.getAllLichTrinhs();
        modelMap.addAttribute("lichTrinhList",lichTrinhList);
        List<LichTrinh> lichTrinhToDay=new ArrayList<LichTrinh>();
        long millis = System.currentTimeMillis();
        Date date=new Date(millis);
        for(LichTrinh lichTrinh:lichTrinhList){
            if(new Date(lichTrinh.getThoiGianXuatPhat().getTime()).equals(date)){
                lichTrinhToDay.add(lichTrinh);
            }
            System.out.println("Check ngay coi: "+new Date(lichTrinh.getThoiGianXuatPhat().getTime()).equals(date));
        }
        modelMap.addAttribute("lichTrinhToDay",lichTrinhToDay);
        List<ThongKeLichTrinh> thongKeLichTrinhList=new ArrayList<ThongKeLichTrinh>();
        System.out.println("So luong lich trinh list: "+ lichTrinhList.size() );
        if(lichTrinhList.size()>=0)
        for (LichTrinh lichTrinh:lichTrinhList) {
            thongKeLichTrinhList.add(getDoanhThuByLichTrinh(lichTrinh));
        }
        System.out.println("So luong lich trinh thong ke "+thongKeLichTrinhList.size());
        modelMap.addAttribute("thongKeLichTrinhList", thongKeLichTrinhList);
        BigDecimal tongDoanhThu=BigDecimal.ZERO;
        for(ThongKeLichTrinh thongKeLichTrinh:thongKeLichTrinhList){
            tongDoanhThu=tongDoanhThu.add(thongKeLichTrinh.getDoanhThu());
        }
        modelMap.addAttribute("tongDoanhThu",tongDoanhThu);
        return "QuanLyThongKe";
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
