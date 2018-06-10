package courses.recipe.project.demo.services;

import courses.recipe.project.demo.model.UnitOfMeasure;
import courses.recipe.project.demo.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Optional<UnitOfMeasure> findByDescription(String description) {
        return unitOfMeasureRepository.findByDescription(description);
    }
}
