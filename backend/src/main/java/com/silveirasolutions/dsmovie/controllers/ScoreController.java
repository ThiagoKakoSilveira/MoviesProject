package com.silveirasolutions.dsmovie.controllers;

import com.silveirasolutions.dsmovie.dto.MovieDTO;
import com.silveirasolutions.dsmovie.dto.ScoreDTO;
import com.silveirasolutions.dsmovie.services.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
@AllArgsConstructor
public class ScoreController {

    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
        return scoreService.saveScore(scoreDTO);
    }
}