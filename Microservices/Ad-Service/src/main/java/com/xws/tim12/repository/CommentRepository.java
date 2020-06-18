package com.xws.tim12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
	List<Comment> findAll();

}
