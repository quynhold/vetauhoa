package vetauhoa.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vetauhoa.entity.Ga;
import vetauhoa.entity.LichTrinh;
import vetauhoa.entity.Toa;
import vetauhoa.service.GaService;
import vetauhoa.service.LichTrinhService;
import vetauhoa.service.ToaService;
import java.math.BigDecimal;

public class ThanhToan {
    @Autowired
    LichTrinhService lichTrinhService;
    @Autowired
    ToaService toaService;
    @Autowired
    GaService gaService;
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
