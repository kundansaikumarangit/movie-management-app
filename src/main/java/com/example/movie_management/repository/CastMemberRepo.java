package com.example.movie_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_management.model.CastMember;

public interface CastMemberRepo extends JpaRepository<CastMember,Long> {

}
