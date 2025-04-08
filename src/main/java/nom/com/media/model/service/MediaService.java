package nom.com.media.model.service;

import nom.com.media.model.entity.Media;
import nom.com.media.model.repository.MediaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MediaService {
    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }
    public List<Media> getMedia() {
        return mediaRepository.findAll();
    }
    public Media getMediaById(@PathVariable Long id) {
        return mediaRepository.findById(id).orElseThrow( ()-> new RuntimeException( "Media not Found!!!" ) );
    }
    public Media createMedia(Media media){
        return mediaRepository.save(media);
    }
    public boolean deleteMedia(@PathVariable Long id) {
        mediaRepository.deleteById(id);
        return true;
    }

}
