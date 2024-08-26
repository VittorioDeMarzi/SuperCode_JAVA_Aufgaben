package de.supercode.FotoManagment.contollers;

import de.supercode.FotoManagment.entities.Photo;
import de.supercode.FotoManagment.errors.ApiError;
import de.supercode.FotoManagment.servicies.PhotoService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoController {
    PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    // post
    @PostMapping("/photo")
    public Photo setPhoto (@RequestBody Photo photo) {
        return photoService.setPhoto(photo);
    }

    // get
    @GetMapping("")
    public ArrayList<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/{filename}")
    public ResponseEntity<?> getPhotoByName(@PathVariable String filename) {
        Photo photo = photoService.getPhotoByName(filename);
        if (photo == null) return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Picture not found!!"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(photo,HttpStatus.FOUND);
    }

    @GetMapping("/photo")
    public ArrayList<Photo> filterByType(@RequestParam String type) {
        return photoService.filterByType(type);
    }

    @GetMapping("/sort")
    public ArrayList<Photo> sortPhotos(@RequestParam Boolean ascending) {
        if (ascending) return photoService.sortPhotosASC();
        else return photoService.sortPhotosDESC();
    }
}
