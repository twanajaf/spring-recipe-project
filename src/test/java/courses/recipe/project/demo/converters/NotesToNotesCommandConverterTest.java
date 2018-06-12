package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.NotesCommand;
import courses.recipe.project.demo.model.Notes;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotesToNotesCommandConverterTest {
    private NotesToNotesCommandConverter classUnderTest = new NotesToNotesCommandConverter();

    @Test
    public void convert() {
        Notes notes = new Notes();
        notes.setRecipeNotes("notes");
        NotesCommand actual = classUnderTest.convert(notes);

        assertThat(actual.getRecipeNotes(), is("notes"));
    }

}