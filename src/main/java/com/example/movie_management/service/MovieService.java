package com.example.movie_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_management.model.CastMember;
import com.example.movie_management.model.Genre;
import com.example.movie_management.model.Movie;
import com.example.movie_management.repository.GenreRepo;
import com.example.movie_management.repository.MovieRepo;

@Service
public class MovieService  {
	
	@Autowired
	private MovieRepo repo;
	@Autowired
	private GenreRepo gRepo;

	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		repo.save(movie);
	}

	public void addGenre(Genre genre) {
		// TODO Auto-generated method stub
		gRepo.save(genre);
		
	}

	public List<Genre> findAllGenres() {
		// TODO Auto-generated method stub
		 return gRepo.findAll();
	}

	public  List<Movie> findAllMovies() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public  Optional<Movie> getMovieById(Long id) {
		// TODO Auto-generated method stub
		
		return repo.findById(id);
	}

	public void updateMovie(Long id, Movie updatedMovie) {
		// TODO Auto-generated method stub
		 Movie movieObj = repo.findById(updatedMovie.getId()).get();
		 movieObj.setTitle(updatedMovie.getTitle());
		 movieObj.setDescription(updatedMovie.getDescription());
		 movieObj.setDuration(updatedMovie.getDuration());
		 movieObj.setReleaseYear(updatedMovie.getReleaseYear());
		 movieObj.setGenre(updatedMovie.getGenre());
		 repo.save(movieObj);
	}

	public void deleteMovie(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
}
