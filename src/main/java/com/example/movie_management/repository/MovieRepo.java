package com.example.movie_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie_management.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long>{

}
