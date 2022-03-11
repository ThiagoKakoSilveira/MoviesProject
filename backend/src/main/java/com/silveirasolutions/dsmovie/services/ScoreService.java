package com.silveirasolutions.dsmovie.services;

import com.silveirasolutions.dsmovie.dto.MovieDTO;
import com.silveirasolutions.dsmovie.dto.ScoreDTO;
import com.silveirasolutions.dsmovie.entities.Movie;
import com.silveirasolutions.dsmovie.entities.Score;
import com.silveirasolutions.dsmovie.entities.User;
import com.silveirasolutions.dsmovie.repositories.MovieRepository;
import com.silveirasolutions.dsmovie.repositories.ScoreRepository;
import com.silveirasolutions.dsmovie.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@AllArgsConstructor
public class ScoreService {

    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());

        if (Objects.isNull(user)) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;

        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}