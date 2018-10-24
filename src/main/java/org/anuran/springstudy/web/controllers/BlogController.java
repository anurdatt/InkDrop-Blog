package org.anuran.springstudy.web.controllers;

import java.util.List;

import org.anuran.springstudy.annotations.PageableRequest;
import org.anuran.springstudy.data.entites.views.PostView;
import org.anuran.springstudy.data.entites.views.TagView;
import org.anuran.springstudy.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@Autowired
	BlogService blogService;
	
	private final int pageSize = 5;
	private final Sort sort = new Sort(Direction.DESC, "postedDt");
	
	@RequestMapping("/")
	public String abc() {
		System.out.println("Inside abc()");
		
		return "home";
	}
	
	@RequestMapping("/blog/page/{page}")
	@PageableRequest(path="page")
	public String blog(Model model, @PathVariable int page) {
		System.out.println("Inside blog()");
		
		PageRequest pageRequest = new PageRequest(page, this.pageSize, this.sort);
		Page<PostView> posts = blogService.getAllPosts(pageRequest);
		List<TagView> tags = blogService.getAllTags(new Sort(Direction.ASC, "name"));
		model.addAttribute("posts", posts.getContent());
		model.addAttribute("tags", tags);
		model.addAttribute("tease", true);
		model.addAttribute("isLastPage", posts.isLast());
		return "blog/blog";
	}
	
	@RequestMapping("/blog/tag/{tagId}/page/{page}")
	@PageableRequest(path="page")
	public String blogByTag(Model model, @PathVariable Integer tagId, @PathVariable int page) {
		
		PageRequest pageRequest = PageRequest.of(page, this.pageSize, this.sort);
		Page<PostView> posts = blogService.getPostsByTag(tagId, pageRequest);
		List<TagView> tags = blogService.getAllTags(new Sort(Direction.ASC, "name"));
		model.addAttribute("posts", posts.getContent());
		model.addAttribute("tags", tags);
		model.addAttribute("tease", true);
		model.addAttribute("isLastPage", posts.isLast());
		return "blog/blog";
	}
}

