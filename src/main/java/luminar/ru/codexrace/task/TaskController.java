package luminar.ru.codexrace.task;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody @Valid CreateTaskDto createTaskDto) {
        Task task = taskService.createTask(createTaskDto);
        return ResponseEntity.ok(task);
    }
    @GetMapping()
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


}
