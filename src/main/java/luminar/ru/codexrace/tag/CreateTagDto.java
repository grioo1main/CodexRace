package luminar.ru.codexrace.tag;

import jakarta.validation.constraints.NotBlank;

public record CreateTagDto(
    @NotBlank
    String name
){}
