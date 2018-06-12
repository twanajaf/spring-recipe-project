package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.CategoryCommand;
import courses.recipe.project.demo.model.Category;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CategoryToCategoryCommandConverterTest {
    private CategoryToCategoryCommandConverter classUnderTest = new CategoryToCategoryCommandConverter();
    @Test
    public void convert() {
        Category category = new Category();
        category.setName("name");
        CategoryCommand actual = classUnderTest.convert(category);

        assertThat(actual.getName(), is("name"));
    }

}