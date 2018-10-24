package org.anuran.springstudy.services;

import java.util.List;
import org.anuran.springstudy.data.entites.views.PostView;
import org.anuran.springstudy.data.entites.views.TagView;
import org.anuran.springstudy.data.entities.Comment;
import org.anuran.springstudy.data.repositories.CommentRepository;
import org.anuran.springstudy.data.repositories.PostViewRepository;
import org.anuran.springstudy.data.repositories.TagViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogService {

	@Autowired
	PostViewRepository postViewRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	TagViewRepository tagViewRepository;
	
	public List<PostView> getAllPosts() {
		return postViewRepository.findAll();
	}
	
	public Page<PostView> getAllPosts(PageRequest pageRequest) {
		return postViewRepository.findAll(pageRequest);
	}
	
	public PostView getOnePost(Integer postid) {
		return postViewRepository.findById(postid).get();	
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
	}
	
	public Comment getOneComment(Integer commentid) {
		return commentRepository.findById(commentid).get();	
	}
	
	public List<TagView> getAllTags(Sort sort) {
		return tagViewRepository.findAll(sort);
	}
	
	public Page<PostView> getPostsByTag(int tagid, PageRequest pageRequest) {
		return postViewRepository.findByTag(tagid, pageRequest);
	}
	
	
}
