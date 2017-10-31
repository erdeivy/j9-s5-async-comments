package com.jrz.microservices.comments.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jrz.microservices.comments.model.Comment;

@Repository
public interface CommentDao extends MongoRepository<Comment, ObjectId> {
	public List<Comment> findAllByIsbn(String isbn);
	public List<Comment> findAll();
	public Comment insert(Comment comment);
}
