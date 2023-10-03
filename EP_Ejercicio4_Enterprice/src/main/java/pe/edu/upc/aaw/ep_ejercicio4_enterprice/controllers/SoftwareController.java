package pe.edu.upc.aaw.ep_ejercicio4_enterprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.dtos.QueryDTO;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.dtos.SoftwareDTO;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Software;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.serviceinterfaces.ISoftwareService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api2")
public class SoftwareController {
    @Autowired
    private ISoftwareService jmtrSs;

    @PostMapping("/software")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody SoftwareDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        Software jmtrD = jmtrM.map(jmtrDto, Software.class);
        jmtrSs.insert(jmtrD);
    }

    @GetMapping("/software/{nameEnterprice}")
    @PreAuthorize("hasAuthority('USER')")
    public List<SoftwareDTO> findByJmtrEnterprice_JmtrNameOrderByJmtrNameAsc(@PathVariable("nameEnterprice") String jmtrNameEnterprice) {
        return jmtrSs.findByJmtrEnterprice_JmtrNameOrderByJmtrNameAsc(jmtrNameEnterprice).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,SoftwareDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/softwares/{nameEnterprice2}")
    @PreAuthorize("hasAuthority('USER')")
    public List<SoftwareDTO> listSoftwarePerNameEnterprise(@PathVariable("nameEnterprice2") String jmtrNameEnterprice) {
        return jmtrSs.listSoftwarePerNameEnterprise(jmtrNameEnterprice).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,SoftwareDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/softwares2/{nameEnterprice3}")
    @PreAuthorize("hasAuthority('USER')")
    public List<QueryDTO> listSoftwarePerNameEnterprise2(@PathVariable("nameEnterprice3")String jmtrNameEnterprice2){
        List<String[]> jmtrLista= jmtrSs.listSoftwarePerNameEnterprise2(jmtrNameEnterprice2);
        List<QueryDTO> jmtrListaDTO = new ArrayList<>();

        for (String[] data:jmtrLista){
            QueryDTO jmtrDto = new QueryDTO();
            jmtrDto.setJmtrNameSoftware(data[0]);
            jmtrDto.setJmtrCategory(data[1]);
            jmtrListaDTO.add(jmtrDto);
        }
        return jmtrListaDTO;
    }
}
