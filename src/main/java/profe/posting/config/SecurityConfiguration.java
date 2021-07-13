package profe.posting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("alumno").password("root").roles("ALUMNO"));
        auth.inMemoryAuthentication()
                .withUser(users.username("profe").password("root").roles("PROFESOR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/js/**","/css/**", "/img/**","/").permitAll();
//                .antMatchers("/profesor/**").hasRole("PROFESOR")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/iniciarSesion")
//                .loginProcessingUrl("/autenticar")
//                .permitAll()
//                .and()
//                .logout().permitAll();
    }
}
