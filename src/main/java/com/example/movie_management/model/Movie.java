package com.example.movie_management.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int duration;
    private int releaseYear;

    
    @OneToMany(mappedBy="movie" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CastMember> castMembers;
    
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<CastMember> getCastMembers() {
		return castMembers;
	}

	public void setCastMembers(List<CastMember> castMembers) {
		this.castMembers = castMembers;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Movie() {
		super();
	}
	
    
    
    
}
