package pe.edu.upc.aaw.ep_ejercicio3_universidad.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.dtos.QueryDTO;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.dtos.StudentDTO;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.Student;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceinterfaces.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api2")
public class StudentController {
    @Autowired
    private IStudentService jmtrSs;

    @PostMapping("/students")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody StudentDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        Student jmtrD = jmtrM.map(jmtrDto, Student.class);
        jmtrSs.insert(jmtrD);
    }

    @GetMapping("/students_q/{qualification}")
    @PreAuthorize("hasAuthority('USER')")
    public List<QueryDTO> listStudentPerGreatestWeightedAverage(@PathVariable("qualification")String jmtrQualification){
        List<String[]> jmtrLista=jmtrSs.listStudentPerGreatestWeightedAverage(Double.parseDouble(jmtrQualification));
        List<QueryDTO> jmtrListaDTO = new ArrayList<>();

        for (String[] data:jmtrLista){
            QueryDTO jmtrDto = new QueryDTO();
            jmtrDto.setJmtrNameStudent(data[0]);
            jmtrDto.setJmtrWeightedAverage(Double.parseDouble(data[1]));
            jmtrListaDTO.add(jmtrDto);
        }
        return jmtrListaDTO;
    }

    @GetMapping("/students_q2/{qualification2}")
    @PreAuthorize("hasAuthority('USER')")
    public List<StudentDTO> findByJmtrWeightedAverage(@PathVariable("qualification2") String jmtrIdUni2) {
        return jmtrSs.findByJmtrWeightedAverageIsGreaterThanEqualOrderByJmtrNameAsc(Double.parseDouble(jmtrIdUni2)).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,StudentDTO.class);
        }).collect(Collectors.toList());
    }

    //-------------------------------------------------------------------------------------
    @GetMapping("/students_u/{id_university}")
    @PreAuthorize("hasAuthority('USER')")
    public List<StudentDTO> listStudentPerIdUniversity(@PathVariable("id_university")String jmtrQIdUniversity){
        return jmtrSs.listStudentPerIdUniversity(Long.parseLong(jmtrQIdUniversity)).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,StudentDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/students_u2/{id_university}")
    @PreAuthorize("hasAuthority('USER')")
    public List<StudentDTO> findByJmtrUniversity_JmtrIdUniversity(@PathVariable("id_university") String jmtrIdUni) {
        return jmtrSs.findByJmtrUniversity_JmtrIdUniversity(Long.parseLong(jmtrIdUni)).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,StudentDTO.class);
        }).collect(Collectors.toList());
    }
    //-------------------------------------------------------------------------------------



}
