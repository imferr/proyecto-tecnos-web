package bo.ucb.edu.internship.api;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
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


public class MediaController {

    private final StorageService storageService;
    private final HttpServletRequest request;   


    @PostMapping("/upload")
    public List<Map<String, String>> uploadFiles(@RequestParam("files") List<MultipartFile> files) {
    List<Map<String, String>> fileUrls = new ArrayList<>();

    for (MultipartFile file : files) {
        String path = storageService.store(file);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder.fromHttpUrl(host).path("/media/").path(path).toUriString();
        Map<String, String> fileUrl = Collections.singletonMap("url", url);
        fileUrls.add(fileUrl);
    }

    return fileUrls;
    }

    @GetMapping("{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());

        return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_TYPE, contentType).body(file);
    }    
}

