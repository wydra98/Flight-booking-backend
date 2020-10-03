package flight_booking.backend.security;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import flight_booking.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class JwtFilter extends BasicAuthenticationFilter {

    @Autowired
    private JwtService jwtService;

    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
        try {
            String token = request.getHeader("authorization");
            if (token == null) {
                throw new IllegalStateException();
            } else {
                if (jwtService == null) {
                    ServletContext context = request.getSession().getServletContext();
                    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, context);
                }
                UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                chain.doFilter(request, response);
            }
        } catch (IllegalStateException e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Wrong or empty token!");
        } catch (ServletException e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "ServletException");
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        DecodedJWT decodedJWT = jwtService.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(claims.get("role").asString()));
        return new UsernamePasswordAuthenticationToken(claims.get("email").asString(), null, simpleGrantedAuthorities);
    }
}
