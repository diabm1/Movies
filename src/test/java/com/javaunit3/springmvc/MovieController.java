package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Controller
public class MovieController {
    private final BestMovieService bestMovieService;

    @Autowired
    private SessionFactory sessionFactory;

    public MovieController(BestMovieService bestMovieService) {
        this.bestMovieService = bestMovieService;
    }

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model) {
        String bestMovie = bestMovieService.getBestMovie().getTitle();
        model.addAttribute("BestMovie", bestMovie);
        return "bestMovie";
    }

    @RequestMapping("/voteForBestMovieForm")
    public String getVoteForBestMovieForm() {
        return "voteForBestMovie";
    }

    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(@RequestParam("movieTitle") String movieTitle, Model model) {
        model.addAttribute("votedMovieTitle", movieTitle);
        return "voteForBestMovie";
    }

    @GetMapping("/addMovieForm")
    public String addMovieForm() {
        return "addMovie";
    }

    @PostMapping("/addMovie")
    @Transactional
    public String addMovie(@RequestParam("title") String title,
                           @RequestParam("maturityRating") String maturityRating,
                           @RequestParam("genre") String genre) {
        MovieEntity movie = new MovieEntity();
        movie.setTitle(title);
        movie.setMaturityRating(maturityRating);
        movie.setGenre(genre);

        try (Session session = sessionFactory.getCurrentSession()) {
            session.save(movie);
        }

        return "redirect:/";
    }
}
