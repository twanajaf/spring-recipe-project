package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.CategoryCommand;
import courses.recipe.project.demo.model.Category;

public class CategoryToCategoryCommandConverter {
    public CategoryCommand convert(Category category) {
        CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(category.getId());
        categoryCommand.setName(category.getName());

        return categoryCommand;
    }
}
