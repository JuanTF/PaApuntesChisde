package pe.edu.upc.aaw.ep_ejercicio1.serviceinterfaces;

import pe.edu.upc.aaw.ep_ejercicio1.entities.Ingredient;

import java.util.List;

public interface IIngredientService {
    public void insert(Ingredient jmtrIngredient);
    //(1) Listar ingredientes por categoria
    public List<String[]> listIngredientsPerCategory(String category);
    public List<Ingredient> listIngredientsPerCategory2(String jmtrCategory);

    //(2) QuantityIngredientsPerDifficultDessert
    public List<String[]> QuantityIngredientsPerDifficultDessert();
    //(3) Listar ingredientes por idDessert
    public List<Ingredient> listIngredientsPerIdDessert(int jmtrIdDessert);
    public List<Ingredient> findByJmtrDessert_JmtrIdDessert(int jmtrQIdDessert);
}
