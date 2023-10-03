package pe.edu.upc.aaw.ep_ejercicio4_enterprice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String jmtrSecret;
    public String getUsernameFromToken(String jmtrToken) {
        return getClaimFromToken(jmtrToken, Claims::getSubject);
    }
    public Date getExpirationDateFromToken(String jmtrToken) {
        return getClaimFromToken(jmtrToken, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String jmtrToken, Function<Claims, T> jmtrClaimsResolver) {
        final Claims jmtrClaims = getAllClaimsFromToken(jmtrToken);
        return jmtrClaimsResolver.apply(jmtrClaims);
    }
    private Claims getAllClaimsFromToken(String jmtrToken) {
        return Jwts.parser().setSigningKey(jmtrSecret).parseClaimsJws(jmtrToken).getBody();
    }
    private Boolean isTokenExpired(String jmtrToken) {
        final Date jmtrExpiration = getExpirationDateFromToken(jmtrToken);
        return jmtrExpiration.before(new Date());
    }
    public String generateToken(UserDetails jmtrUserDetails) {
        Map<String, Object> jmtrClaims = new HashMap<>();
        jmtrClaims.put("jmtrName", "Juan");
        jmtrClaims.put("jmtrRole",jmtrUserDetails.getAuthorities().stream().map(r->r.getAuthority()).collect(Collectors.joining()));
        return doGenerateToken(jmtrClaims, jmtrUserDetails.getUsername());
    }
    private String doGenerateToken(Map<String, Object> jmtrClaims, String jmtrSubject) {

        return Jwts.builder().setClaims(jmtrClaims).setSubject(jmtrSubject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, jmtrSecret).compact();
    }
    public Boolean validateToken(String jmtrToken, UserDetails jmtrUserDetails) {
        final String username = getUsernameFromToken(jmtrToken);
        return (username.equals(jmtrUserDetails.getUsername()) && !isTokenExpired(jmtrToken));
    }
}
