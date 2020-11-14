package flight_booking.backend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/login",
            "/register"
    };

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                .antMatchers("/airlines/get").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/airlines/delete").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/airlines").hasAuthority("ROLE_ADMIN")
                .antMatchers("/airports/get").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/airports/delete").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/airports").hasAuthority("ROLE_ADMIN")
                .antMatchers("/airports/delete/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/flights*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/flights/delete/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/passengers").hasAuthority("ROLE_ADMIN")
                .antMatchers("/passengers/trip").hasAuthority("ROLE_USER")
                .antMatchers("/passengers/delete/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/passengers/add").hasAuthority("ROLE_USER")
                .antMatchers("/trips/createTrip").hasAuthority("ROLE_USER")
                .antMatchers("/trips/findTrips").hasAuthority("ROLE_USER")
                .antMatchers("/trips").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/users").hasAuthority("ROLE_ADMIN")
                .antMatchers("/users/modifyUser").hasAuthority("ROLE_USER")
                .antMatchers("/users/delete").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .and().addFilter(new JwtFilter(authenticationManager()))
                .csrf().disable();
    }
}
