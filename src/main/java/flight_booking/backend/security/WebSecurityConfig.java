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
                .antMatchers("/airlines").hasAuthority("ROLE_ADMIN")
                .antMatchers("/airlines/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/airlines/get").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")

                .antMatchers("/airports").hasAuthority("ROLE_ADMIN")
                .antMatchers("/airports/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/airports/get").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")

                .antMatchers("/flights").hasAuthority("ROLE_ADMIN")
                .antMatchers("/flights/delete").hasAuthority("ROLE_ADMIN")
                .antMatchers("/flights/get").hasAuthority("ROLE_ADMIN")

                .antMatchers("/passengers/get").hasAuthority("ROLE_ADMIN")
                .antMatchers("/passengers/delete").hasAuthority("ROLE_ADMIN")
                .antMatchers("/passengers/trip").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")

                .antMatchers("/trips/user").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/trips/all").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/trips/delete").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/trips/createTrip").hasAuthority("ROLE_USER")
                .antMatchers("/trips/findTrips").hasAuthority("ROLE_USER")

                .antMatchers("/users/get").hasAuthority("ROLE_ADMIN")
                .antMatchers("/users/trip").hasAuthority("ROLE_ADMIN")
                .antMatchers("/users/delete").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/users/modifyUser").hasAuthority("ROLE_USER")
                .and().addFilter(new JwtFilter(authenticationManager()))
                .csrf().disable();
    }
}
