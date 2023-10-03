package pe.edu.upc.aaw.ep_ejercicio1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.ep_ejercicio1.dtos.IngredientDTO;
import pe.edu.upc.aaw.ep_ejercicio1.dtos.Query2DTO;
import pe.edu.upc.aaw.ep_ejercicio1.dtos.Query3DTO;
import pe.edu.upc.aaw.ep_ejercicio1.dtos.QueryDTO;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Dessert;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Ingredient;
import pe.edu.upc.aaw.ep_ejercicio1.repositories.IDessertRepository;
import pe.edu.upc.aaw.ep_ejercicio1.serviceinterfaces.IIngredientService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IIngredientService jmtrIs;
    @Autowired
    private IDessertRepository jmtrDesRep;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody IngredientDTO jmtrDto) {
        ModelMapper jmtrM = new ModelMapper();
        Ingredient jmtrI = jmtrM.map(jmtrDto, Ingredient.class);
        jmtrIs.insert(jmtrI);
    }
    //----------------------------------------------------------------------------------------------------
    //(1) Listar ingredientes por categoria
    @PostMapping("/category")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<IngredientDTO> listIngredientsPerCategory(@RequestBody QueryDTO jmtrCategoryDTO){
        List<String[]> jmtrLista=jmtrIs.listIngredientsPerCategory(jmtrCategoryDTO.getJmtrCategoryDTO());
        List<IngredientDTO> jmtrListaDTO = new ArrayList<>();

        for (String[] data:jmtrLista){
            IngredientDTO jmtrDto = new IngredientDTO();
            jmtrDto.setJmtrIdIngredient(Integer.parseInt(data[0]));
            jmtrDto.setJmtrNameIngredient((data[1]));
            jmtrDto.setJmtrQuantityIngredient(Integer.parseInt(data[2]));
            jmtrDto.setJmtrDessert(jmtrDesRep.findById(Integer.parseInt(data[3])).orElse(new Dessert()));

            jmtrListaDTO.add(jmtrDto);
        }
        return jmtrListaDTO;
    }

    @GetMapping("/category2/{jmtrCategoryDTO}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<IngredientDTO> listIngredientsPerCategory2(@PathVariable("jmtrCategoryDTO") String jmtrCategoryDTO2){
        return jmtrIs.listIngredientsPerCategory2(jmtrCategoryDTO2).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,IngredientDTO.class);
        }).collect(Collectors.toList());
    }

    //----------------------------------------------------------------------------------------------------
    //(2) QuantityIngredientsPerDifficultDessert
    @GetMapping("/category3")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Query2DTO> QuantityIngredientsPerDifficultDessert(){
        List<String[]> jmtrLista=jmtrIs.QuantityIngredientsPerDifficultDessert();
        List<Query2DTO> jmtrListaDTO = new ArrayList<>();
        for (String[] data:jmtrLista){
            Query2DTO jmtrDto = new Query2DTO();
            jmtrDto.setJmtrDifficultyDessertDTO(data[0]);
            jmtrDto.setJmtrQuantityIngredientsDTO(Integer.parseInt(data[1]));
            jmtrListaDTO.add(jmtrDto);
        }
        return jmtrListaDTO;
    }



    //----------------------------------------------------------------------------------------------------
    //(3) Listar ingredientes por idDessert
    @GetMapping("/category4/{jmtrIdDessert}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<IngredientDTO> listIngredientsPerIdDessert(@PathVariable("jmtrIdDessert")String jmtrIdDessert){
        return jmtrIs.listIngredientsPerIdDessert(Integer.parseInt(jmtrIdDessert)).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,IngredientDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/category5/{jmtrIdDessert2}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<IngredientDTO> listIngredientsPerIdDessert2(@PathVariable("jmtrIdDessert2")String jmtrIdDessert){
        return jmtrIs.findByJmtrDessert_JmtrIdDessert(Integer.parseInt(jmtrIdDessert)).stream().map(jmtrX->{
            ModelMapper jmtrM=new ModelMapper();
            return jmtrM.map(jmtrX,IngredientDTO.class);
        }).collect(Collectors.toList());
    }
    //----------------------------------------------------------------------------------------------------


}
