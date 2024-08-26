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

    // post_ che if the picture is already in DB, otherwise it will be saved.
    @PostMapping("/photo")
    public ResponseEntity<?> setPhoto (@RequestBody Photo photoToAdd) {
        Photo photo = photoService.getPhotoByName(photoToAdd.getFilename());
        if (photo == null) {
            photoService.setPhoto(photoToAdd);
            return new ResponseEntity<>(photoToAdd,HttpStatus.CREATED);
        } else return new ResponseEntity<>(new ApiError(HttpStatus.ALREADY_REPORTED, "Picture is already in Data Bank"), HttpStatus.ALREADY_REPORTED);
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

    // delete
    @DeleteMapping("/{filename}")
    public ResponseEntity<?> deletePhoto(@PathVariable String filename) {
        Photo photo = photoService.getPhotoByName(filename);
        if (photo == null) return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Picture not found!!"), HttpStatus.NOT_FOUND);
        else {
            photoService.deletePhoto(filename);
            return new ResponseEntity<>(photo, HttpStatus.GONE);
        }
    }

    // put
    @PutMapping("/{filename}")
    public ResponseEntity<?> updatePhoto(@PathVariable String filename, @RequestBody Photo newPhoto) {
        Photo photoToUpdate = photoService.getPhotoByName(filename);
        if (photoToUpdate == null) return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Picture not found!!"), HttpStatus.NOT_FOUND);
        else {
            photoService.updatePhoto(filename, newPhoto);
            return new ResponseEntity<>(newPhoto, HttpStatus.GONE);
        }
    }
}
