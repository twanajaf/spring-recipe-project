package courses.recipe.project.demo.repositories;

import courses.recipe.project.demo.model.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {
}
