package com.jrz.microservices.comments.service.impl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrz.microservices.comments.dao.CommentDao;
import com.jrz.microservices.comments.model.Comment;
import com.jrz.microservices.comments.service.CommentService;
import com.jrz.microservices.dto.comments.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	private static final Logger LOGGER = Logger.getLogger(CommentServiceImpl.class.getName());

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<CommentDto> findComments(String isbn) {
		return commentDao.findAllByIsbn(isbn).stream().map(from -> mapper.map(from, CommentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CommentDto> findAllComments() {
		return commentDao.findAll().stream().map(from -> mapper.map(from, CommentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CommentDto postComment(CommentDto comment) {
		LOGGER.info("Inserting comment "
				+ (comment != null ? comment.getAuthor() + " " + comment.getText() + " " + comment.getIsbn() : "NULL"));
		return (CommentDto) mapper.map(commentDao.insert((Comment) mapper.map(comment, Comment.class)),
				CommentDto.class);
	}

}
