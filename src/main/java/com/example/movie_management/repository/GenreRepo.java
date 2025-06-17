package com.example.movie_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_management.model.Genre;

public interface GenreRepo extends JpaRepository<Genre, Long> {

}
