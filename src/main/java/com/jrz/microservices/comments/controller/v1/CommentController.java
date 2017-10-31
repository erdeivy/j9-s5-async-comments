package com.jrz.microservices.comments.controller.v1;

import org.springframework.http.ResponseEntity;

import com.jrz.microservices.dto.comments.CommentDto;


public interface CommentController {
	public ResponseEntity<?> getBookComments(String isbn);
	
	public ResponseEntity<?> getAllComments();
	
	public ResponseEntity<CommentDto> postComment(CommentDto comment);
}
