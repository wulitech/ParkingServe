package la.chopper.spring.boot.core.component;

import la.chopper.spring.boot.core.config.JwtLoginFilter;
import la.chopper.spring.boot.core.util.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author TonyTonyChopper
 * @see org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
 * @param <H>
 */
public class CustomFormLoginConfigurer <H extends HttpSecurityBuilder<H>> extends
        AbstractAuthenticationFilterConfigurer<H, CustomFormLoginConfigurer<H>, UsernamePasswordAuthenticationFilter> {

    /**
     * Creates a new instance
     * @see HttpSecurity#formLogin()
     */
    public CustomFormLoginConfigurer(AuthenticationManager authenticationManager, JwtTokenUtils jwtTokenUtils) {
        super(new JwtLoginFilter(authenticationManager,jwtTokenUtils), null);
        usernameParameter("username");
        passwordParameter("password");
    }
    @Override
    protected RequestMatcher createLoginProcessingUrlMatcher(String loginProcessingUrl) {
        return new AntPathRequestMatcher(loginProcessingUrl, "POST");
    }

    public CustomFormLoginConfigurer<H> usernameParameter(String usernameParameter) {
        getAuthenticationFilter().setUsernameParameter(usernameParameter);
        return this;
    }

    public CustomFormLoginConfigurer<H> passwordParameter(String passwordParameter) {
        getAuthenticationFilter().setPasswordParameter(passwordParameter);
        return this;
    }

}
