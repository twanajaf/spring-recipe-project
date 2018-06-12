package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.IngredientCommand;
import courses.recipe.project.demo.model.Ingredient;
import courses.recipe.project.demo.model.UnitOfMeasure;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IngredientToIngredientCommandConverterTest {
    IngredientToIngredientCommandConverter classUndertest = new IngredientToIngredientCommandConverter();

    @Test
    public void testConvert() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);
        ingredient.setUnitOfMeasure(unitOfMeasure);
        IngredientCommand actual = classUndertest.convert(ingredient);

        assertThat(actual.getId(), is(1L));
        assertThat(actual.getUnitOfMeasure().getId(), is(1L));
    }
}