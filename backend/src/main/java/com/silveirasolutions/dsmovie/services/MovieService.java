package com.silveirasolutions.dsmovie.services;

import com.silveirasolutions.dsmovie.dto.MovieDTO;
import com.silveirasolutions.dsmovie.entities.Movie;
import com.silveirasolutions.dsmovie.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        return result.map(movie -> new MovieDTO(movie));
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        return new MovieDTO(movieRepository.findById(id).get());
    }
}