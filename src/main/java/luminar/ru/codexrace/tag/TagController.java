package luminar.ru.codexrace.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id){
        Tag tag = tagService.getTagById(id);
        return ResponseEntity.ok(tag);
    }
    @PostMapping("/create")
    public ResponseEntity<Tag> createTag(@RequestBody CreateTagDto createTagDto){
        Tag tag = tagService.createTag(createTagDto);
        return ResponseEntity.ok(tag);
    }
    @GetMapping()
    public List<Tag> getTagById(){
        return tagService.getAllTags();
    }

}
