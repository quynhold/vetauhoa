package vetauhoa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vetauhoa.service.TaiKhoanService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                        .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                        .anyRequest().permitAll()
                        .and()
                .formLogin()
                        .loginPage("/dang-nhap")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/trang-chu")
                        .failureUrl("/dang-nhap?error=failed")
                        .and()
                .exceptionHandling()
                        .accessDeniedPage("/dang-nhap?error=deny")
                        .and()
                .logout()
                        .logoutUrl("/dang-xuat")
                        .logoutSuccessUrl("/trang-chu");
        System.out.println();
    }

}
