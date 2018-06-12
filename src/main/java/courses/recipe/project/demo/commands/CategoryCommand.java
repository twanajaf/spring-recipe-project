package courses.recipe.project.demo.commands;

import courses.recipe.project.demo.model.Recipe;

import java.util.List;
import java.util.Objects;

public class CategoryCommand {
    private Long id;
    private String name;
    private List<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryCommand category = (CategoryCommand) o;
        return Objects.equals(id, category.id) &&
               Objects.equals(name, category.name) &&
               Objects.equals(recipes, category.recipes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, recipes);
    }

    @Override
    public String toString() {
        return name;
    }
}
