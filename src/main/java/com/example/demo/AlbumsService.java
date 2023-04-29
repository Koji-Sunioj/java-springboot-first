package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumsService {
    @Autowired
    private AlbumsRepository albumsRepository;

    public List<Albums> findAll() {
        return albumsRepository.findAll();
    }

    public Albums findById(Integer album_id) {
        return albumsRepository.findById(album_id).orElse(null);
    }

    public void deleteById(Integer album_id) {
        albumsRepository.deleteById(album_id);
    }

    public Albums createOne(Albums album) {
        return albumsRepository.save(album);
    }
}