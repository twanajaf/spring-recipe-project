package courses.recipe.project.demo.repositories;

import courses.recipe.project.demo.model.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository classUnderTest;

    @Test
    @DirtiesContext
    public void testFindByDescription() {
        Optional<UnitOfMeasure> actual = classUnderTest.findByDescription("dash");

        assertThat(actual.get().getDescription(), is("dash"));
    }

    @Test
    @DirtiesContext
    public void testFindByDescriptionCup() {
        Optional<UnitOfMeasure> actual = classUnderTest.findByDescription("Cup");

        assertThat(actual.get().getDescription(), is("Cup"));
    }
}