package bo.ucb.edu.internship.bl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.*;
import org.springframework.stereotype.Service;

@Service
public class FileSystemStorageService implements StorageService {

    @Value("${media.location}")
    private String mediaLocation;

    private Path rootLocation;

    @Override
    @PostConstruct
    public void init(){
        rootLocation = Paths.get(mediaLocation);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }

    @Override
    public String store(MultipartFile file) {
        
        try {
            if(file.isEmpty()){
                throw new RuntimeException("Failded to store empty file");
            }

            String filename = file.getOriginalFilename();
            Path destinationFile = rootLocation.resolve(Paths.get(filename)).normalize().toAbsolutePath();

            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            } 
            
            return filename;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file ", e);
        }

    }

    @Override
    public Resource loadAsResource(String filename) {

        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            } else {
                throw new RuntimeException("Could not read the file" + filename);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file " + filename);
        }
    }


    
}
