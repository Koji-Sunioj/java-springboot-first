package com.example.demo;
import java.util.HashMap;
import java.util.List;

import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("albums")
public class AlbumsController {
    @Autowired
    private AlbumsService albumsService;

    @GetMapping("/")
    public HashMap<String,List<Albums>> findAll(){
        List<Albums> albums = albumsService.findAll();
        HashMap<String, List<Albums>> response = new HashMap<String, List<Albums>>();
        response.put("albums",albums);
        return response;
    }

    @GetMapping("/{album_id}")
    public HashMap<String,Albums> findByAlbumId(@PathVariable Integer album_id)
    {
        Albums album = albumsService.findById(album_id);
        if (album == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no album found");
        }
        HashMap<String,Albums> response = new HashMap<String,Albums>();
        response.put("album",album);
        return response;
    }

     @PostMapping(value="/",consumes = {"application/json"})
    public HashMap<String,Object> createOne(@RequestBody Albums album) {
        Albums createdAlbum = albumsService.createOne(album);
        HashMap<String,Object> response = new HashMap<String, Object>();
        response.put("message","successfully created new album");
        response.put("album",createdAlbum);
        return response;
    }

    @DeleteMapping("/{album_id}")
    public HashMap<String, String> deleteOne(@PathVariable Integer album_id) {
        albumsService.deleteById(album_id);
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("message",String.format("sucessfully deleted album with id %s",album_id));
        return response;
    }

    @PatchMapping(value="/{album_id}",consumes = {"application/json"})
    public HashMap<String, Object> updateOne(@RequestBody Albums updateAlbum, @PathVariable Integer album_id) {
        Albums patchedAlbum = albumsService.update(updateAlbum,album_id);
        HashMap<String, Object> response = new HashMap<String, Object>();
        response.put("message",String.format("sucessfully updated album with id %s",album_id));
        response.put("album",patchedAlbum);
        return response;
    }

}