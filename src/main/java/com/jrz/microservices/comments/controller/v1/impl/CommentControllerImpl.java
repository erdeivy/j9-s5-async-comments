package com.jrz.microservices.comments.controller.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jrz.microservices.comments.controller.v1.CommentController;
import com.jrz.microservices.comments.service.CommentService;
import com.jrz.microservices.dto.comments.CommentDto;

@RestController
@RequestMapping(value = "/v1/comments")
public class CommentControllerImpl implements CommentController {
	@Autowired
	private CommentService commentService;
	
	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllComments() {
		return ResponseEntity.ok(commentService.findAllComments());
	}

	@Override
	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public ResponseEntity<?> getBookComments(@PathVariable String isbn) {
		return ResponseEntity.ok(commentService.findComments(isbn));
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CommentDto> postComment(@RequestBody CommentDto comment) {
		return ResponseEntity.ok(commentService.postComment(comment));
	}
	
	

}
