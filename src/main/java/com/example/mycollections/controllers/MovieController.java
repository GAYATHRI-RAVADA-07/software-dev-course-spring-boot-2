package com.example.mycollections.controllers;


import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{

        add(new Movie("Napoleon Dynamite", "Jared Hess", 2004, 95));
        add(new Movie("Black Panther", "Ryan Coogler", 2018, 134));
        add(new Movie("Toy Story", "John Lasseter",1995, 81));
    }};

    @GetMapping("/json")
    public List<Movie> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml(){
        String movieList = "<ul>";

        for(Movie movie : movies) {
            movieList += "<li>" + movie + "<li>";
        }

        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }



}

