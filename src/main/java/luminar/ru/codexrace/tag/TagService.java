package luminar.ru.codexrace.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Tag getTagById(Long id){
        return tagRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND , "Тега с таким id нет"
        ));
    }
    public Tag createTag(CreateTagDto dto) {
        if (tagRepository.findByName(dto.name()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, // 409 Conflict - идеально для дубликатов
                    "Тег с таким именем уже существует: " + dto.name()
            );
        }
        Tag tag = new Tag();
        tag.setName(dto.name());
        return tagRepository.save(tag);
    }
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }
}
