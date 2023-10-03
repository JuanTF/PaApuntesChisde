package pe.edu.upc.aaw.ep_ejercicio3_universidad.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.dtos.UniversityDTO;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.University;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceinterfaces.IUniversityService;

@RestController
@RequestMapping("/api")
public class UniversityController {
    @Autowired
    private IUniversityService jmtrUs;

    @PostMapping("/universities")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody UniversityDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        University jmtrD = jmtrM.map(jmtrDto, University.class);
        jmtrUs.insert(jmtrD);
    }
}
