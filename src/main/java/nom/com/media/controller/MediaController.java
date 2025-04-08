package nom.com.media.controller;

import nom.com.media.model.entity.Media;
import nom.com.media.model.repository.MediaRepository;
import nom.com.media.model.service.MediaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/media")
//@CrossOrigin(origins = "http://localhost:3000")
public class MediaController {
     private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<List<Media>> getMedia() {
        List<Media> mediaList = mediaService.getMedia();
        if (mediaList == null || mediaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mediaList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Media getMediaById(@PathVariable Long id) {
       return mediaService.getMediaById(id);
    }

    @PostMapping("create-media")
    public ResponseEntity<Media> createMedia(@RequestBody Media media) {
        Media createdMedia = mediaService.createMedia(media);
        return new ResponseEntity<>(createdMedia, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable Long id) {
       boolean isDeleted = mediaService.deleteMedia(id);
       if(isDeleted) {
           return new ResponseEntity<>("Deleted", HttpStatus.OK);
       }else {
              return new ResponseEntity<>("Media not found", HttpStatus.NOT_FOUND);
       }
    }
}
