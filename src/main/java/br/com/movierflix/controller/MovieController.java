package br.com.movierflix.controller;

import br.com.movierflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movierflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
}
