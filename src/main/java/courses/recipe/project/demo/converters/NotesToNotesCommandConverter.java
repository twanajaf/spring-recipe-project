package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.NotesCommand;
import courses.recipe.project.demo.model.Notes;

public class NotesToNotesCommandConverter {

    public NotesCommand convert(Notes notes) {
        NotesCommand command = new NotesCommand();
        command.setId(notes.getId());
        command.setRecipeNotes(notes.getRecipeNotes());

        return command;
    }
}
