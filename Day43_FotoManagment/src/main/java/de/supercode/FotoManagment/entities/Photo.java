package de.supercode.FotoManagment.entities;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class Photo {
    private String filename;
    private long size;  // The file size of the photo in bytes.
    private LocalDateTime creationDate;
    private String fileType;  // The file type of the photo (e.g., JPEG, PNG).
    private String path;

    public long getSize() {
        return size;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getFileType() {
        return fileType;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return size == photo.size && Objects.equals(filename, photo.filename) && Objects.equals(creationDate, photo.creationDate) && Objects.equals(fileType, photo.fileType) && Objects.equals(path, photo.path);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, size, creationDate, fileType, path);
    }
}

