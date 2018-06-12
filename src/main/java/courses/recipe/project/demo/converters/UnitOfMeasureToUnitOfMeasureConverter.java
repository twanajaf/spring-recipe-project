package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.UnitOfMeasureCommand;
import courses.recipe.project.demo.model.UnitOfMeasure;

public class UnitOfMeasureToUnitOfMeasureConverter {
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setDescription(unitOfMeasure.getDescription());
        command.setId(unitOfMeasure.getId());

        return command;
    }
}
