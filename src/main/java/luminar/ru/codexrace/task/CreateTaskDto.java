package luminar.ru.codexrace.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record CreateTaskDto(

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotBlank
        @Size(max = 20)
        String difficulty,

        @NotNull
        @Positive
        Integer timeLimitMs,

        @NotNull
        @Positive
        Integer memoryLimitMb,

        @NotEmpty
        Set<String> tagNames

) {
    public Task toEntity() {
        Task task = new Task();
        task.setTitle(this.title());
        task.setDescription(this.description());
        task.setDifficulty(this.difficulty());
        task.setTimeLimitMs(this.timeLimitMs());
        task.setMemoryLimitMb(this.memoryLimitMb());
        task.setCreatedAt(java.time.LocalDateTime.now());
        return task;
    }

}