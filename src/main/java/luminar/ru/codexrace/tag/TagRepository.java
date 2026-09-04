package luminar.ru.codexrace.tag;

import jakarta.validation.constraints.NotBlank;
import luminar.ru.codexrace.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag , Long> {

    Optional<Object> findByName(@NotBlank String name);
}
