package com.example.demo;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("albums")
public class AlbumsController {
    @Autowired
    private AlbumsService albumsService;

    @GetMapping("/")
    public List<Albums> findAll(){
        return albumsService.findAll();
    }

    @GetMapping("/{album_id}")
    public Albums findByAlbumId(@PathVariable Integer album_id)
    {
        Albums album = albumsService.findById(album_id);
        if (album == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no album found");
        }
        return album;
    }

    @PostMapping(value="/",consumes = {"application/json"})
    public Albums createOne(@RequestBody Albums album) {
        System.out.println("creating");
        return albumsService.createOne(album);
    }

    @DeleteMapping("/{album_id}")
    public void deleteOne(@PathVariable Integer album_id) {
        albumsService.deleteById(album_id);
    }

}