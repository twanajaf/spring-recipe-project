package courses.recipe.project.demo.commands;

import courses.recipe.project.demo.model.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class RecipeCommand {
    private Long id;
    private String description;
    private Integer preparationTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String direction;
    private Byte[] image;
    private NotesCommand notes;
    private List<IngredientCommand> ingredients = new ArrayList<>();
    private Difficulty difficulty;
    private List<CategoryCommand> categories = new ArrayList<>();

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

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public NotesCommand getNotes() {
        return notes;
    }

    public void setNotes(NotesCommand notes) {
        this.notes = notes;
    }

    public List<IngredientCommand> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientCommand> ingredients) {
        this.ingredients = ingredients;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<CategoryCommand> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryCommand> categories) {
        this.categories = categories;
    }
}
