package de.supercode.FotoManagment.repositories;

import de.supercode.FotoManagment.entities.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PhotoRepository {
    private ArrayList<Photo> photosDB;

    public PhotoRepository() {
        this.photosDB = new ArrayList<>();
    }

    // crate
    public Photo setPhoto (Photo photo) {
        photosDB.add(photo);
        return photosDB.stream().filter(p -> p==photo).findFirst().orElseThrow();
    }

    // read
    public ArrayList<Photo> getAllPhotos() {
        return photosDB;
    }

    public Photo getPhotoByName (String name) {
        return photosDB.stream().filter(p-> Objects.equals(p.getFilename(), name)).findFirst().orElse(null);
    }

    public ArrayList<Photo> filterByType (String type) {
        return photosDB.stream().filter(p -> Objects.equals(p.getFileType(), type)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Photo> sortPhotosASC() {
        return new ArrayList<>(photosDB.stream().sorted(Comparator.comparing(Photo::getSize)).toList());
    }

    public ArrayList<Photo> sortPhotosDESC() {
        return new ArrayList<>(photosDB.stream().sorted(Comparator.comparing(Photo::getSize).reversed()).toList());
    }

    // delete
    public Boolean deletePhoto(String name) {
        return photosDB.removeIf(p -> Objects.equals(p.getFilename(), name));
    }

}
