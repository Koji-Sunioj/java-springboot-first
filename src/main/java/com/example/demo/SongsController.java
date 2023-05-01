package com.example.demo;
import java.util.HashMap;
import java.util.List;

import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("songs")
public class SongsController {
    @Autowired
    private SongsService songsService;

    @GetMapping("/")
    public HashMap<String,List<Songs>> findAll(){
        List<Songs> songs = songsService.findAll();
        HashMap<String, List<Songs>> response = new HashMap<String, List<Songs>>();
        response.put("songs",songs);
        return response;
    }

}