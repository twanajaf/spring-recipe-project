package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.UnitOfMeasureCommand;
import courses.recipe.project.demo.model.UnitOfMeasure;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureConverterTest {
    private UnitOfMeasureToUnitOfMeasureConverter classUnderTest = new UnitOfMeasureToUnitOfMeasureConverter();

    @Test
    public void convert() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("description");

        UnitOfMeasureCommand actual = classUnderTest.convert(unitOfMeasure);

        assertThat(actual.getDescription(), is("description"));
    }

}