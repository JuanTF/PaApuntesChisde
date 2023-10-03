package pe.edu.upc.aaw.ep_ejercicio1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.ep_ejercicio1.dtos.DessertDTO;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Dessert;
import pe.edu.upc.aaw.ep_ejercicio1.serviceinterfaces.IDessertService;

@RestController
@RequestMapping("/desserts")
public class DessertController {
    @Autowired
    private IDessertService jmtrDs;

    @PostMapping
    public void registrar(@RequestBody DessertDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        Dessert jmtrD = jmtrM.map(jmtrDto, Dessert.class);
        jmtrDs.insert(jmtrD);
    }
}
