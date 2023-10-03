package pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.Users;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository jmtrRepo;

    @Override
    public UserDetails loadUserByUsername(String jmtrUsername) throws UsernameNotFoundException {
        Users jmtrUser = jmtrRepo.findByJmtrUsername(jmtrUsername);

        if(jmtrUser == null) {
            throw new UsernameNotFoundException(String.format("User not exists", jmtrUsername));
        }

        List<GrantedAuthority> jmtrRoles = new ArrayList<>();

        jmtrUser.getJmtrRoles().forEach(rol -> {
            jmtrRoles.add(new SimpleGrantedAuthority(rol.getJmtrRol()));
        });

        UserDetails jmtrUd = new org.springframework.security.core.userdetails.User(jmtrUser.getJmtrUsername(), jmtrUser.getJmtrPassword(), jmtrUser.getJmtrEnabled(), true, true, true, jmtrRoles);

        return jmtrUd;
    }
}
