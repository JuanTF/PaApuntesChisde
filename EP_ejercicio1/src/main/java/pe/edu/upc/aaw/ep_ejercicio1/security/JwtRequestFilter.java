package pe.edu.upc.aaw.ep_ejercicio1.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.edu.upc.aaw.ep_ejercicio1.serviceimplements.JwtUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUserDetailsService jmtrJwtUserDetailsService;
    @Autowired
    private JwtTokenUtil jmtrJwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest jmtrRequest, HttpServletResponse jmtrResponse, FilterChain jmtrFilterChain) throws ServletException, IOException {
        final String jmtrRequestTokenHeader = jmtrRequest.getHeader("Authorization");
        String jmtrUsername = null;
        String jmtrJwtToken = null;

        if (jmtrRequestTokenHeader != null && jmtrRequestTokenHeader.startsWith("Bearer ")) {
            jmtrJwtToken = jmtrRequestTokenHeader.substring(7);
            try {
                jmtrUsername = jmtrJwtTokenUtil.getUsernameFromToken(jmtrJwtToken);
            } catch (IllegalArgumentException jmtrE) {
                System.out.println("No se puede encontrar el token JWT");
            } catch (ExpiredJwtException jmtrE) {
                System.out.println("Token JWT ha expirado");
            }
        } else {
            logger.warn("JWT Token no inicia con la palabra Bearer");
        }

        if (jmtrUsername != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails jmtrUserDetails = this.jmtrJwtUserDetailsService.loadUserByUsername(jmtrUsername);

            if (jmtrJwtTokenUtil.validateToken(jmtrJwtToken, jmtrUserDetails)) {

                UsernamePasswordAuthenticationToken jmtrUsernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        jmtrUserDetails, null, jmtrUserDetails.getAuthorities());
                jmtrUsernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(jmtrRequest));
                SecurityContextHolder.getContext().setAuthentication(jmtrUsernamePasswordAuthenticationToken);
            }
        }
        jmtrFilterChain.doFilter(jmtrRequest, jmtrResponse);
    }
}
