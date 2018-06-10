package courses.recipe.project.demo.services;

import courses.recipe.project.demo.model.Category;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> findByName(String name);
}
