package luminar.ru.codexrace.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Task> createTask(Long id) {
//        Task task = taskService.createTask();
//        return ResponseEntity.ok(task);
//    }
    @GetMapping(    )
    public List<Task> getAllTasks() {
        // Если в базе пусто, репозиторий вернет пустую коллекцию,
        // а Spring автоматически отдаст её клиенту как [] с кодом 200 OK
        return taskService.getAllTasks();
    }

}
