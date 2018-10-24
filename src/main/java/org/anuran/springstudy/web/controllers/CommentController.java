package org.anuran.springstudy.web.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.anuran.springstudy.data.entites.views.PostView;
import org.anuran.springstudy.data.entites.views.TagView;
import org.anuran.springstudy.data.entities.Comment;
import org.anuran.springstudy.data.validators.CommentValidator;
import org.anuran.springstudy.services.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute Comment comment, BindingResult result, Model model, 
			HttpServletRequest request) {
		System.err.println("I am here..");
		
		Integer postId = comment.getPost().getPostId();
		
		if (result.hasErrors() || !request.getParameter("mandatory").isEmpty() /*|| !isValid(comment.getSite())*/) {
			PostView post = blogService.getOnePost(postId);
			List<TagView> tags = blogService.getAllTags(new Sort(Direction.ASC, "name"));
			model.addAttribute("post", post);
			model.addAttribute("tags", tags);
			model.addAttribute("isSingle", true);
			return "blog/post";
		}
		else {
			comment.setPostedDt(new Date());
			comment.setIpAddress(request.getRemoteAddr());
			blogService.saveComment(comment);
			
			return "redirect:/post/"+postId.toString();
		}
		
	}
	
	/*private boolean isValid(String field) {
		return StringUtils.containsIgnoreCase(field, "http");
	}*/
	
	@InitBinder("comment")
	public void initBinder(WebDataBinder wdb) {
		wdb.setValidator(new CommentValidator());
	}
}
