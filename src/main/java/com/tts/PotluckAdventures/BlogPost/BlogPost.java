package com.tts.PotluckAdventures.BlogPost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	private String blogEntry;
	
	
// step 1 create class attributes
// step 2 creat non-arg constructor
// step 3 creat argument constructor
// step 4 create getters and setters
// step 5 create toString() method
	
	//no-arg constructor
	public BlogPost() {
		
	}
	//constructor with Args
	public BlogPost(String title, String author, String blogEntry) {
		this.title = title;
		this.author = author;
		this.blogEntry = blogEntry;
	}
	
	//Setters and Getters
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBlogEntry() {
		return blogEntry;
	}
	public void setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
	}
	
	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", author=" + author + ", blogEntry=" + blogEntry + "]";
	}
	
	

}//endClass
