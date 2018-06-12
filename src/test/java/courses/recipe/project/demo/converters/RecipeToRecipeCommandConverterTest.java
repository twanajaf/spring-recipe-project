package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.CategoryCommand;
import courses.recipe.project.demo.commands.IngredientCommand;
import courses.recipe.project.demo.commands.RecipeCommand;
import courses.recipe.project.demo.model.Recipe;
import courses.recipe.project.demo.model.RecipeFactory;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RecipeToRecipeCommandConverterTest {
    private RecipeToRecipeCommandConverter classUnderTest = new RecipeToRecipeCommandConverter();

    @Test
    public void testConvert() {
        Recipe recipe = RecipeFactory.createRecipe();
        RecipeCommand actual = classUnderTest.convert(recipe);

        assertThatIngredients(actual.getIngredients());
        assertCategories(actual.getCategories());
        assertThat(actual.getCookTime(), is(0));
        assertThat(actual.getPreparationTime(), is(10));
        assertThat(actual.getServings(), is(4));
        assertThat(actual.getNotes().getRecipeNotes(), containsString("Be careful handling chiles if using. Wash your hands thoroughly after"));
    }

    private void assertThatIngredients(List<IngredientCommand> actual) {
        IngredientCommand command = actual.get(2);
        assertThat(command.getUnitOfMeasure().getDescription(), is("Tablespoon"));
        assertThat(command.getDescription(), is("of fresh lime juice or lemon juice"));
    }

    private void assertCategories(List<CategoryCommand> actual) {
        assertThat(actual.get(0).getName(), is("Mexican"));
    }
}