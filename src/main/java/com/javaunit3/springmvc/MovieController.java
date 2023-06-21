package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class MovieController {

    private final BestMovieService bestMovieService;
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(BestMovieService bestMovieService, MovieRepository movieRepository) {
        this.bestMovieService = bestMovieService;
        this.movieRepository = movieRepository;
    }

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model) {
        MovieEntity bestMovie = bestMovieService.getMovieWithMostVotes();
        List<String> voters = bestMovieService.getVotersForMovie(bestMovie.getId());

        model.addAttribute("BestMovie", bestMovie.getTitle());
        model.addAttribute("Voters", voters);

        return "bestMovie";
    }

    @PostMapping("/voteForBestMovie")
    @Transactional
    public String voteForBestMovie(@RequestParam("movieId") Integer movieId,
                                   @RequestParam("voterName") String voterName,
                                   Model model) {

        MovieEntity movie = bestMovieService.getMovieById(movieId);

        if (movie != null) {
            VoteEntity vote = new VoteEntity();
            vote.setVoterName(voterName);
            movie.addVote(vote);

            bestMovieService.saveMovie(movie);
            model.addAttribute("votedMovieTitle", movie.getTitle());
        }

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

        bestMovieService.saveMovie(movie);

        return "redirect:/";
    }
}
