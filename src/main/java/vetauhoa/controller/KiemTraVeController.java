package vetauhoa.controller;

import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vetauhoa.entity.HanhKhach;
import vetauhoa.entity.PhieuDat;
import vetauhoa.entity.Ve;
import vetauhoa.service.HanhKhachService;
import vetauhoa.service.PhieuDatService;
import vetauhoa.service.VeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KiemTraVeController {
    @Autowired
    PhieuDatService phieuDatService;
    @Autowired
    HanhKhachService hanhKhachService;
    @Autowired
    VeService veService;
    @RequestMapping(value="/phieu-dat",method = RequestMethod.GET)
    public String formKiemTraVe(HttpServletRequest request,HttpServletResponse response){
        return "TimKiemVe";
    }
    @RequestMapping(value="/phieu-dat",method=RequestMethod.POST)
    public String kiemTraVe(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
        String cccd=request.getParameter("CCCD");
        String veid=request.getParameter("veid");
        System.out.println("String cccd:"+cccd+", String veid:"+veid);
        Ve ve=new Ve();
        HanhKhach hanhKhach=new HanhKhach();
        List<PhieuDat> phieuDatList=new ArrayList<PhieuDat>();
        if(!veid.isEmpty()){

            ve=veService.getVeById(veid);
            if(veService.getVeById(veid)==null){
                request.setAttribute("message","Không tìm thấy vé đặt phù hợp");
                return "TimKiemVe";
            }
            phieuDatList.add(ve.getPhieuDatByMaPhieuDat());
            System.out.println("Case1:"+phieuDatList.size());
        }else if(!cccd.isEmpty()){
            hanhKhach = hanhKhachService.getHanhKhachsByCccd(cccd);
            if(hanhKhach==null){
                request.setAttribute("message","Không tìm thấy vé đặt phù hợp");
                return "TimKiemVe";
            }
            phieuDatList=phieuDatService.getPhieuDatsByHanhKhachId(hanhKhach.getMaHanhKhach());
            System.out.println("Case2:"+hanhKhach.getMaHanhKhach()+","+phieuDatList.size());
        }else{
            request.setAttribute("message","Không tìm thấy vé đặt phù hợp");
            return "TimKiemVe";
        }
        request.setAttribute("phieuDatList",phieuDatList);
        return "DanhSachVe";

    }
    @RequestMapping(value = "/tra-ve", method = RequestMethod.GET)
    public String kiemTraVeHandle(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        return "Error";
    }

}
