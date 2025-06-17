package com.example.movie_management.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.movie_management.model.CastMember;
import com.example.movie_management.model.Genre;
import com.example.movie_management.model.Movie;
import com.example.movie_management.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@PostMapping("/add")
	public String addMovie(@ModelAttribute Movie movie)
	{
		service.addMovie(movie);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/add-movie")
	public String add(Model model)
	{
		
		model.addAttribute("movie",new Movie());
		model.addAttribute("genres",service.findAllGenres());
		return "add-movie";
	}
	
	
	@GetMapping("/add-genre")
	public String addGenre(Model model)
	{
		model.addAttribute("genre",new Genre());
		return "genre";
	}
	
	@PostMapping("/addGenre")
	public String addGenre(@ModelAttribute Genre genre)
	{
		service.addGenre(genre);
		return "redirect:/";
	}
	
	
	@GetMapping("/update-movie/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
	  System.out.println("inside -2");
	    Movie movie = service.getMovieById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
	    model.addAttribute("movie", movie);
	    model.addAttribute("genres", service.findAllGenres());
	    return "update-movie";
	}
	
	
	@PostMapping("/update-movie/{id}")
	public String updateMovie(
	        @PathVariable("id") Long id,
	        @ModelAttribute("movie") Movie updatedMovie,
	        BindingResult result
	) {
	    if (result.hasErrors()) {
	        return "update_movie";
	    }
	    System.out.println("inside-3");
	    // Update the movie
	    service.updateMovie(id, updatedMovie);
	    
	    return "redirect:/movie-details"; 
	}
	
	@GetMapping("/delete-movie/{id}")
	public String deleteMovieForm(
	        @PathVariable("id") Long id
	       
	) {
	    service.deleteMovie(id);
	    
	    return "redirect:/movie-details"; 
	}

	
	@GetMapping("/movie-details")
	public String allMovies(Model model)
	{
		model.addAttribute("moviesList",service.findAllMovies());
		return "all-movies";
	}
	
	@GetMapping("/")
	public String homePage(Model model)
	{
		model.addAttribute("message","welcome to movie management system");
		return "index";
		
	}
	
	

}
