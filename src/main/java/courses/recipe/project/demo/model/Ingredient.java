package courses.recipe.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * This class describes an ingredient.
 */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @ManyToMany
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Ingredient(String description) {
        this.description = description;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(description, that.description) &&
               Objects.equals(amount, that.amount) &&
               Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, amount, recipe);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
               "id=" + id +
               ", description='" + description + '\'' +
               ", amount=" + amount +
               ", recipe=" + recipe +
               '}';
    }
}
