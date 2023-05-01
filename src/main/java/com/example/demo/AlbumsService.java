package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

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

    public Albums update(Albums updatedAlbum,Integer album_id) {
        System.out.println(updatedAlbum.getArtist());
        Albums album = albumsRepository.findById(album_id).get();
        album.setDate(updatedAlbum.getRelease_date());
        album.setPrice(updatedAlbum.getPrice());
        album.setTitle(updatedAlbum.getTitle());
        album.setStock(updatedAlbum.getStock());
        album.setArtist(updatedAlbum.getArtist());
        albumsRepository.save(album);
        return album;
    }
}