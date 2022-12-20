package vetauhoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vetauhoa.entity.Ga;
import vetauhoa.entity.LichTrinh;
import vetauhoa.service.GaService;
import vetauhoa.service.LichTrinhService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private LichTrinhService lichTrinhService;
    @Autowired
    private GaService gaService;

    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ModelAndView HomePage() {
        List<Ga> gaList=gaService.getAllGas();
        ModelAndView modelAndView = new ModelAndView("Home");
        modelAndView.addObject("gaList",gaList);
        return modelAndView;
    }

    @RequestMapping(value = "/tim-kiem", method = RequestMethod.POST)
    public String ResurtPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
//        Lấy request
            String tenGaDi = request.getParameter("tenGaDi");
            String tenGaDen = request.getParameter("tenGaDen");
            String ngayDiStr = request.getParameter("ngayDi");
//        Test
            System.out.println(tenGaDi);
            System.out.println(ngayDiStr);
            System.out.println(tenGaDen);
//            Trans
            String maGaDi = gaService.getGaByTenGa(tenGaDi).getMaGa();
            String maGaDen = gaService.getGaByTenGa(tenGaDen).getMaGa();
//            Add to Cookie
            Cookie maGaDenCk = new Cookie("maGaDen", maGaDen);
            response.addCookie(maGaDenCk);
//            Handle
            int giaTriGaDen = gaService.getGaByTenGa(tenGaDen).getKhoangCach();
            List<LichTrinh> lichTrinhList = lichTrinhService.searchLichTrinhs(tenGaDi, giaTriGaDen, ngayDiStr);
            modelMap.addAttribute("tenGaDi",tenGaDi);
            modelMap.addAttribute("tenGaDen",tenGaDen);
            modelMap.addAttribute("list", lichTrinhList);
            modelMap.addAttribute("maGaDen", maGaDen);
            modelMap.addAttribute("ngayDi",ngayDiStr);
            //case
            if (lichTrinhList != null && !lichTrinhList.isEmpty()) {
                return "ChonLichTrinh";
            } else {
                request.setAttribute("message", "Không tìm thấy lich trình phù hợp!");
                return "Home";
            }
        }catch (Exception e){
            request.setAttribute("message", "Vui lòng nhập đầy đủ thông tin!");
            return "Home";
        }
    }
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String renderErrorPage(HttpServletRequest httpRequest) {
        int httpErrorCode = getErrorCode(httpRequest);
        switch (httpErrorCode) {
            case 400: {
                return "400";
            }
            case 403: {
                return "403";
            }
            case 404: {
                return "404";
            }
            case 500: {
                return "500";
            }
            default: return "Error";
        }
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}

