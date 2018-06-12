package courses.recipe.project.demo.commands;

import courses.recipe.project.demo.model.Recipe;

import java.math.BigDecimal;

public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private Recipe recipe;
    private UnitOfMeasureCommand unitOfMeasure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasureCommand getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureCommand unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
