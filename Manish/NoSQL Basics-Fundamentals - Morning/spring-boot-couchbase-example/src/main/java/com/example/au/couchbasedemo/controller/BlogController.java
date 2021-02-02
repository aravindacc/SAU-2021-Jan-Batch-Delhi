package com.example.au.couchbasedemo.controller;

import com.example.au.couchbasedemo.model.Blog;
import com.example.au.couchbasedemo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BlogController {
    
    @Autowired
    BlogRepository blogRepository;

    // add new blog
    @PostMapping("/blog")
    public Blog addBlogPost(@RequestBody Blog newBlog) {
        return blogRepository.save(newBlog);
    }

    // get blog by id
    @GetMapping("/blog/{id}")
    public Optional<Blog> getBlog(@PathVariable String id) {
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id);
        } else
            return Optional.empty();
    }

    // delete blog by id
    @DeleteMapping("/blog/{id}")
    public void deleteById(@PathVariable String id) {
        blogRepository.deleteById(id);
    }

    // get all blogs
    @GetMapping("/blog")
    public List<Blog> getAllBlog() {
        return (List<Blog>) blogRepository.findAll();
    }

//    // get all blog for tag
//    @GetMapping("/blog/tags/{tag}")
//    public List<Blog> getBlogByTag(@PathVariable String tag) {
//
//        List<Blog> result = new ArrayList<>();
//
//        // checking each blog for provided tag, if exists add in result
//        for (Blog blog: blogRepository.findAll()) {
//            if (blog.getTags().contains(tag)) result.add(blog);
//        }
//
//        return result;
//    }
    // get all blog for tags
    @GetMapping("/blog/tags/{tags}") // need to pass as "-" seperated
    public List<Blog> getBlogByTags(@PathVariable String tags) {

        List<Blog> result = new ArrayList<>();
        String[] tagList = tags.split("-");

        // checking each blog for provided tag, if exists add in result
        for (Blog blog: blogRepository.findAll()) {
            for (String tag : tagList) {
                if (blog.getTags().contains(tag)) {
                    result.add(blog);
                    break;
                }
            }
        }

        return result;
    }

    // get all blog by a author
    @GetMapping("/blog/author/{author}")
    public Blog getBlogByAuthorName(@PathVariable String author) {
        return blogRepository.findByAuthor(author);
    }

    // delete blog with author and topic
    @DeleteMapping("/blog/topic/{topic}/author/{author}")
    public void deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
        blogRepository.deleteByTopicAndAuthor(topic, author);
    }
}