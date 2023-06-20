package com.javaunit3.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.javaunit3.springmvc")
public class MovieApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MovieApp.class);
        BestMovieService bestMovieService = context.getBean(BestMovieService.class);
        Movie bestMovie = bestMovieService.getBestMovie();

        System.out.println("Title: " + bestMovie.getTitle());
        System.out.println("Maturity Rating: " + bestMovie.getMaturityRating());
        System.out.println("Genre: " + bestMovie.getGenre());
    }
}
