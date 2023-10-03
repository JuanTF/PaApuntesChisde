package pe.edu.upc.aaw.ep_ejercicio1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Ingredient;

import java.util.List;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient,Integer> {
    //(1) Listar ingredientes por categoria (@RequestBody)
    @Query(value = "SELECT ing.jmtr_id_ingredient, ing.jmtr_name_ingredient, ing.jmtr_quantity_ingredient, ing.jmtr_id_dessert \n" +
            " FROM ingredient ing\n" +
            " INNER JOIN dessert des ON ing.jmtr_id_dessert = des.jmtr_id_dessert\n" +
            " WHERE des.jmtr_category_dessert = :category",nativeQuery = true)
    public List<String[]> listIngredientsPerCategory(String category);

    @Query(value = "SELECT ing.*\n" +
            " FROM ingredient ing\n" +
            " INNER JOIN dessert des ON ing.jmtr_id_dessert = des.jmtr_id_dessert\n" +
            " WHERE des.jmtr_category_dessert = :jmtrCategory",nativeQuery = true)
    public List<Ingredient> listIngredientsPerCategory2(String jmtrCategory);


    //(2) QuantityIngredientsPerDifficultDessert
    @Query(value = "SELECT de.jmtr_difficulty_dessert, COUNT(ing.jmtr_id_ingredient)\n" +
            " FROM dessert de\n" +
            " JOIN ingredient ing ON de.jmtr_id_dessert = ing.jmtr_id_dessert\n" +
            " GROUP BY de.jmtr_difficulty_dessert",nativeQuery = true)
    public List<String[]> QuantityIngredientsPerDifficultDessert();

    //(3) Listar ingredientes por idDessert
    @Query(value = "SELECT ing.*\n" +
            " FROM ingredient ing\n" +
            " INNER JOIN dessert des ON ing.jmtr_id_dessert = des.jmtr_id_dessert\n" +
            " WHERE des.jmtr_id_dessert = :jmtrIdDessert",nativeQuery = true)
    public List<Ingredient> listIngredientsPerIdDessert(int jmtrIdDessert);

    public List<Ingredient> findByJmtrDessert_JmtrIdDessert(int jmtrQIdDessert);

}
