package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BestMovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public BestMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieEntity getBestMovie() {
        return movieRepository.getMovieWithMostVotes();
    }

    public MovieEntity getMovieById(Integer movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public void saveMovie(MovieEntity movie) {
        movieRepository.save(movie);
    }

    public MovieEntity getMovieWithMostVotes() {
        return movieRepository.findMovieWithMostVotes();
    }

    public List<String> getVotersForMovie(Integer movieId) {
        MovieEntity movie = movieRepository.findById(movieId).orElse(null);
        List<String> voters = new ArrayList<>();

        if (movie != null) {
            for (VoteEntity vote : movie.getVotes()) {
                voters.add(vote.getVoterName());
            }
        }

        return voters;
    }
}
