package nom.com.media.controller;

import nom.com.media.model.entity.Media;
import nom.com.media.model.repository.MediaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/media")
//@CrossOrigin(origins = "http://localhost:3000")
public class MediaController {

    private final MediaRepository mediaRepository;
    public MediaController(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }
    @GetMapping
    public ResponseEntity<List<Media>>  getAllMedia() {
        List<Media> mediaList = mediaRepository.findAll();
        if (mediaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mediaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Media getMediaById(@PathVariable Long id) {
        return mediaRepository.findById(id).orElseThrow(() -> new RuntimeException("Media not found with id: " + id));
    }

    @PostMapping("create-media")
    public ResponseEntity<Media> createMedia(@RequestBody Media media) {
        Media savedMedia = mediaRepository.save(media);
       return new ResponseEntity<>(savedMedia , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable Long id) {
        if (!mediaRepository.existsById(id)) {
            return new ResponseEntity<>("Media not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        mediaRepository.deleteById(id);
        return new ResponseEntity<>("Media deleted successfully", HttpStatus.NO_CONTENT);  // 204 No Content indicates successful deletion with no response body
    }

}
