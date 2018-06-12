package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.IngredientCommand;
import courses.recipe.project.demo.model.Ingredient;

public class IngredientToIngredientCommandConverter {
    private UnitOfMeasureToUnitOfMeasureConverter unitOfMeasureToUnitOfMeasureConverter = new UnitOfMeasureToUnitOfMeasureConverter();
    public IngredientCommand convert(Ingredient ingredient) {
        IngredientCommand command = new IngredientCommand();
        command.setAmount(ingredient.getAmount());
        command.setDescription(ingredient.getDescription());
        command.setId(ingredient.getId());
        command.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureConverter.convert(ingredient.getUnitOfMeasure()));
        return command;
    }
}
