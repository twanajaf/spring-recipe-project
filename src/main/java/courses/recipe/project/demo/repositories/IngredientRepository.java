package courses.recipe.project.demo.repositories;

import courses.recipe.project.demo.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
