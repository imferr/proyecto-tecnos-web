package bo.ucb.edu.internship.api;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bo.ucb.edu.internship.bl.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/media")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class MediaController {

    private final StorageService storageService;
    
    @PostMapping("/upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file) {
        String filename = storageService.store(file);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/v1/media/")
            .path(filename)
            .toUriString();
    
        return Map.of("url", url);
    }

    @GetMapping("{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());

        return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_TYPE, contentType).body(file);
    }    
}

