package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
    MovieEntity findMovieWithMostVotes();

    MovieEntity getMovieWithMostVotes();
}
