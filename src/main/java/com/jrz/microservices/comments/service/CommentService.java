package com.jrz.microservices.comments.service;

import java.util.List;

import com.jrz.microservices.dto.comments.CommentDto;

public interface CommentService {
	public List<CommentDto> findComments(String isbn);
	
	public List<CommentDto> findAllComments();
	
	public CommentDto postComment(CommentDto comment);
}
