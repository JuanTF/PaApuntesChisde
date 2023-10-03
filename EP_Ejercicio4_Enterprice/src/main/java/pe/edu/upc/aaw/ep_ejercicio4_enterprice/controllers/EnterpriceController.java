package pe.edu.upc.aaw.ep_ejercicio4_enterprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.dtos.EnterpriceDTO;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Enterprice;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.serviceinterfaces.IEnterpriceService;

@RestController
@RequestMapping("/api")
public class EnterpriceController {
    @Autowired
    private IEnterpriceService jmtrEs;

    @PostMapping("/enterprise")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody EnterpriceDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        Enterprice jmtrD = jmtrM.map(jmtrDto, Enterprice.class);
        jmtrEs.insert(jmtrD);
    }
}
