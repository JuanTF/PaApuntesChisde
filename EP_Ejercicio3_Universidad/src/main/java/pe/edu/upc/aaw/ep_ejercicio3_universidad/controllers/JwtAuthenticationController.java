package pe.edu.upc.aaw.ep_ejercicio3_universidad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.security.JwtRequest;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.security.JwtResponse;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.security.JwtTokenUtil;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceimplements.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager jmtrAuthenticationManager;
    @Autowired
    private JwtTokenUtil jmtrJwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jmtrUserDetailsService;
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jmtrAuthenticationRequest) throws Exception {
        authenticate(jmtrAuthenticationRequest.getJmtrUsername(), jmtrAuthenticationRequest.getJmtrPassword());
        final UserDetails jmtrUserDetails = jmtrUserDetailsService.loadUserByUsername(jmtrAuthenticationRequest.getJmtrUsername());
        final String jmtrToken = jmtrJwtTokenUtil.generateToken(jmtrUserDetails);
        return ResponseEntity.ok(new JwtResponse(jmtrToken));
    }
    private void authenticate(String jmtrUsername, String jmtrPassword) throws Exception {
        try {
            jmtrAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jmtrUsername,jmtrPassword));
        } catch (DisabledException jmtrE) {
            throw new Exception("USER_DISABLED", jmtrE);
        } catch (BadCredentialsException jmtrE) {
            throw new Exception("INVALID_CREDENTIALS", jmtrE);
        }
    }
}
