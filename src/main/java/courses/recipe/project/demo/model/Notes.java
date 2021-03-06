package courses.recipe.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Notes {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
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
        Notes notes = (Notes) o;
        return Objects.equals(recipe, notes.recipe) &&
               Objects.equals(recipeNotes, notes.recipeNotes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(recipe, recipeNotes);
    }

    @Override
    public String toString() {
        return "Notes{" +
               "recipe=" + recipe +
               ", recipeNotes='" + recipeNotes + '\'' +
               '}';
    }
}
