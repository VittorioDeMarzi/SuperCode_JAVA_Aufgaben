package de.supercode.FotoManagment.servicies;

import de.supercode.FotoManagment.entities.Photo;
import de.supercode.FotoManagment.repositories.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PhotoService {
    PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    // create
    public Photo setPhoto (Photo photo) {
        return photoRepository.setPhoto(photo);
    }

    // read
    public ArrayList<Photo> getAllPhotos() {
        return photoRepository.getAllPhotos();
    }

    public Photo getPhotoByName (String name) {
        return photoRepository.getPhotoByName(name);
    }

    public ArrayList<Photo> filterByType (String type) {
        return photoRepository.filterByType(type);
    }

    public ArrayList<Photo> sortPhotosASC() {
        return photoRepository.sortPhotosASC();
    }

    public ArrayList<Photo> sortPhotosDESC() {
        return photoRepository.sortPhotosDESC();
    }

    // delete
    public Boolean deletePhoto(String name) {
        return photoRepository.deletePhoto(name);
    }

    // update
    public void updatePhoto(String filename, Photo photo) {
        photoRepository.updatePhoto(filename, photo);
    }
}
