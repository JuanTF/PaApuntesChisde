package pe.edu.upc.aaw.ep_ejercicio2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.ep_ejercicio2.dtos.PaymentDTO;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Member;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Payment;
import pe.edu.upc.aaw.ep_ejercicio2.repositories.IMemberRepository;
import pe.edu.upc.aaw.ep_ejercicio2.serviceinterfaces.IPaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api2")
public class PaymentController {
    @Autowired
    private IPaymentService jmtrPs;
    @Autowired
    private IMemberRepository jmtrMr;

    @PostMapping("/payment")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody PaymentDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        Payment jmtrD = jmtrM.map(jmtrDto, Payment.class);
        jmtrPs.insert(jmtrD);
    }

    @GetMapping("/payments/{code_member}")
    @PreAuthorize("hasAuthority('USER')")
    public List<PaymentDTO> QuantityIngredientsPerDifficultDessert(@PathVariable("code_member") String jmtrQMonth){
        List<String[]> jmtrLista=jmtrPs.ListPaymentMember(Long.parseLong(jmtrQMonth));
        List<PaymentDTO> jmtrListaDTO = new ArrayList<>();

        for (String[] data:jmtrLista){
            PaymentDTO jmtrDto = new PaymentDTO();
            jmtrDto.setJmtrIdPayment(Long.parseLong(data[0]));
            jmtrDto.setJmtrAmount(Double.parseDouble(data[1]));
            jmtrDto.setJmtrMonth(data[2]);
            jmtrDto.setJmtrStatus(Boolean.parseBoolean(data[3]));
            jmtrDto.setJmtrYear(data[4]);
            jmtrDto.setJmtrMember(jmtrMr.findById(Long.parseLong(data[5])).orElse(new Member()));
            jmtrListaDTO.add(jmtrDto);
        }
        return jmtrListaDTO;
    }
    //localhost:8080/api2/payments/2

    @GetMapping("/payments2/{code_member2}")
    @PreAuthorize("hasAuthority('USER')")
    public List<PaymentDTO> listSoftwarePerNameEnterprise(@PathVariable("code_member2") Long jmtrQMonth2) {
        return jmtrPs.ListPaymentMember2(jmtrQMonth2).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,PaymentDTO.class);
        }).collect(Collectors.toList());
    }
    //localhost:8081/api2/payments2/2
}
