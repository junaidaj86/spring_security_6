package green.stitch.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @PreAuthorize("hasRole('ADMIN')")
    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
