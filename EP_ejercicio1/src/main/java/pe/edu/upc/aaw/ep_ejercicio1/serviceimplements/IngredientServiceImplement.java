package pe.edu.upc.aaw.ep_ejercicio1.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Ingredient;
import pe.edu.upc.aaw.ep_ejercicio1.repositories.IIngredientRepository;
import pe.edu.upc.aaw.ep_ejercicio1.serviceinterfaces.IIngredientService;

import java.util.List;

@Service
public class IngredientServiceImplement implements IIngredientService {
    @Autowired
    private IIngredientRepository jmtrIr;

    @Override
    public void insert(Ingredient jmtrIngredient) {
        jmtrIr.save(jmtrIngredient);
    }

    //(3) Listar ingredientes por categoria
    @Override
    public List<String[]> listIngredientsPerCategory(String category) {
        return jmtrIr.listIngredientsPerCategory(category);
    }

    @Override
    public List<Ingredient> listIngredientsPerCategory2(String jmtrCategory) {
        return jmtrIr.listIngredientsPerCategory2(jmtrCategory);
    }

    //(3) QuantityIngredientsPerDifficultDessert
    @Override
    public List<String[]> QuantityIngredientsPerDifficultDessert() {
        return jmtrIr.QuantityIngredientsPerDifficultDessert();
    }
    //(3) Listar ingredientes por idDessert
    @Override
    public List<Ingredient> listIngredientsPerIdDessert(int jmtrIdDessert) {
        return jmtrIr.listIngredientsPerIdDessert(jmtrIdDessert);
    }

    @Override
    public List<Ingredient> findByJmtrDessert_JmtrIdDessert(int jmtrQIdDessert) {
        return jmtrIr.findByJmtrDessert_JmtrIdDessert(jmtrQIdDessert);
    }
}
