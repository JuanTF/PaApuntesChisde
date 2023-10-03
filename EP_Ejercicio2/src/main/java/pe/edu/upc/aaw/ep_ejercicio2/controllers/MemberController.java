package pe.edu.upc.aaw.ep_ejercicio2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.ep_ejercicio2.dtos.MemberDTO;
import pe.edu.upc.aaw.ep_ejercicio2.dtos.QueryDTO;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Member;
import pe.edu.upc.aaw.ep_ejercicio2.serviceinterfaces.IMemberService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private IMemberService jmtrMs;
    @PostMapping("/members")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody MemberDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        Member jmtrD = jmtrM.map(jmtrDto, Member.class);
        jmtrMs.insert(jmtrD);
    }

    @GetMapping("/members/status/{month}")
    @PreAuthorize("hasAuthority('USER')")
    public List<QueryDTO> QuantityIngredientsPerDifficultDessert(@PathVariable("month") String jmtrQMonth){
        List<String[]> jmtrLista=jmtrMs.QuantityMembersPerStatusPerMonth(jmtrQMonth);
        List<QueryDTO> jmtrListaDTO = new ArrayList<>();

        for (String[] data:jmtrLista){
            QueryDTO jmtrDto = new QueryDTO();
            jmtrDto.setJmtrNameClub(data[0]);
            jmtrDto.setJmtrQuantityMembers(Integer.parseInt(data[1]));
            jmtrListaDTO.add(jmtrDto);
        }
        return jmtrListaDTO;
    }

    //localhost:8080/api/members/status/SEPTEMBER


}
