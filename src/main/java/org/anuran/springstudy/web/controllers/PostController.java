package org.anuran.springstudy.web.controllers;

import java.util.List;

import org.anuran.springstudy.data.entites.views.PostView;
import org.anuran.springstudy.data.entites.views.TagView;
import org.anuran.springstudy.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/{postid}")
	public String getPost(@PathVariable Integer postid, Model model) {
		PostView post = blogService.getOnePost(postid);
		List<TagView> tags = blogService.getAllTags(new Sort(Direction.ASC, "name"));
		model.addAttribute("tags", tags);
		model.addAttribute("post", post);
		model.addAttribute("isSingle", true);
		return "blog/post";
	}
}
