package wpartone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wpartone.model.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {

}
