package vetauhoa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vetauhoa.dao.TaiKhoanDao;
import vetauhoa.entity.TaiKhoan;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private TaiKhoanDao taiKhoanDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        TaiKhoan taiKhoan=this.taiKhoanDao.getTaiKhoanByUsername(username);
        System.out.println(username);
        if(taiKhoan==null){
            throw new UsernameNotFoundException("User not found");
        }else{
            System.out.println(taiKhoan.getPassword());
            System.out.println(taiKhoan.getRole());
        }
        List<GrantedAuthority> grantedAuthorities= new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+taiKhoan.getRole());
        grantedAuthorities.add(authority);

        return (UserDetails)new User(taiKhoan.getUsername(), taiKhoan.getPassword(), taiKhoan.isTrangThai(),taiKhoan.isTrangThai(),taiKhoan.isTrangThai(),taiKhoan.isTrangThai(),grantedAuthorities);
    }
}
