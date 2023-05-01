package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongsService {
    @Autowired
    private SongsRepository songsRepository;

    public List<Songs> findAll() {
        return songsRepository.findAll();
    }
}