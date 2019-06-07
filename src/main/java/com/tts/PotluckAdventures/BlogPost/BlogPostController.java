package com.tts.PotluckAdventures.BlogPost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class BlogPostController {
	
	@Autowired//this connects us to the repository that we are using as a database
    private BlogPostRepository blogPostRepository;
//    private static List<BlogPost> posts = new ArrayList<>();

		@GetMapping("/")
		public String index(BlogPost blogPost, Model model) {
			model.addAttribute("posts", blogPostRepository.findAll());
			return "blogpost/index";
		}
		//above the blogpost is referring to the controller
		 //above the index is referring to the template file that is named index in the template folder called blogpost
		
		
		@GetMapping(value = "/blog_posts/new")
	    public String newBlog (BlogPost blogPost) {
	        return "blogpost/new";
			
	    }
		
		//private BlogPost blogPost;
		@PostMapping(value = "/blog_posts/new")
		public String create(BlogPost blogPost, Model model) {
			blogPostRepository.save(blogPost);
//	        posts.add(blogPost);
	        model.addAttribute("title", blogPost.getTitle());
	        model.addAttribute("author", blogPost.getAuthor());
	        model.addAttribute("blogEntry", blogPost.getBlogEntry());
	        return "blogpost/result";
		}
		
	    @RequestMapping(value = "/blog_posts/{id}", method = RequestMethod.DELETE)
	    public String deletePostWithId(@PathVariable Long id, Model model,
	                                   BlogPost blogPost) {
	    	
	        blogPostRepository.deleteById(id);
//	        model.addAttribute("posts", blogPostRepository.findAll());
	        return "blogpost/index";

	    }
		

//		
		@RequestMapping(value="/blogpost/edit/{id}",method=RequestMethod.GET)
		public String showUpdateForm(@PathVariable long id, Model model) {
		    BlogPost blogPost = blogPostRepository.findById(id).orElse(null);
		    model.addAttribute("posts",blogPost);
		        return "blogpost/edit";
		    }

		//update
		@RequestMapping(value="/blogpost/{id}", method = RequestMethod.PUT)
		public String updatePostById(@PathVariable long id, Model model, BlogPost formData) {
			BlogPost editedBlogPost = blogPostRepository.findById(id).orElse(null);
			editedBlogPost.setAuthor(formData.getAuthor());  
			editedBlogPost.setTitle(formData.getTitle()); 
			editedBlogPost.setBlogEntry(formData.getBlogEntry()); 
			blogPostRepository.save(editedBlogPost);
			model.addAttribute("id",editedBlogPost.getId());
			model.addAttribute("title",editedBlogPost.getTitle());
			model.addAttribute("author",editedBlogPost.getAuthor());
			model.addAttribute("blogEntry",editedBlogPost.getBlogEntry());
			return"blogpost/result";
		}
		
		//show page
		@RequestMapping(value = "/blogpost/{id}", method = RequestMethod.GET)
		public String getPostWithId(@PathVariable long id,BlogPost blogPost,Model model) {

		    BlogPost post = blogPostRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id " +id));
		   model.addAttribute("post",post);
		   return "blogpost/show";

		}
	    
}//endClass
