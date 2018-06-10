package courses.recipe.project.demo.services;

import courses.recipe.project.demo.model.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureService {
    Optional<UnitOfMeasure> findByDescription(String description);
}
