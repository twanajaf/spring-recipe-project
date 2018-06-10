package courses.recipe.project.demo.bootstrap;

import courses.recipe.project.demo.repositories.IngredientRepository;
import courses.recipe.project.demo.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public DevBootstrap(RecipeRepository recipeRepository,
                        IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
/*        Ingredient ingredient = new Ingredient( "meat");
        ingredientRepository.save(ingredient);
        Recipe recipe = new Recipe();
        recipe.getIngredients().add(ingredient);

        recipeRepository.save(recipe);*/
    }
}
