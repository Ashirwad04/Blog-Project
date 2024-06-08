package Blog.Project.controllers;


import Blog.Project.config.AppConstant;
import Blog.Project.paylods.ApiResponse;

import Blog.Project.paylods.PostDto;
import Blog.Project.paylods.PostResponse;
import Blog.Project.services.FileService;
import Blog.Project.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {


    @Autowired
    private FileService fileService;

    @Autowired
    private PostService postService;


    @Value("${project.image}")
    private String path;

    // Create post
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    // Update post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(
            @RequestBody PostDto postDto,
            @PathVariable Integer postId) {
        PostDto updatedPost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    // Delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted", true);
    }

    // Get all posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "shortBy",defaultValue = "postId",required = false)String shortBy
    ) {

        PostResponse postsResponse = this.postService.getAllPosts(pageNumber, pageSize,shortBy);
        return new ResponseEntity<>(postsResponse, HttpStatus.OK);
    }

    // Get post by ID
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        PostDto post = this.postService.getPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    // Get posts by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostByCategory(
            @PathVariable Integer categoryId,
            @RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize) {
        PostResponse postsResponse = this.postService.getPostByCategory(categoryId, pageNumber, pageSize);
        return new ResponseEntity<>(postsResponse, HttpStatus.OK);
    }

    // Get posts by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getPostByUser(
            @PathVariable Integer userId,
            @RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize) {
        PostResponse postsResponse = this.postService.getPostByUser(userId, pageNumber, pageSize);
        return new ResponseEntity<>(postsResponse, HttpStatus.OK);
    }


    //search
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(
            @PathVariable("keywords") String keywords
    ){
        List<PostDto> result=  this.postService.searchPost(keywords);
        return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);

    }

    //post image upload

    // Post image upload
    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadImage(
            @RequestParam("image") MultipartFile image,
            @PathVariable Integer postId) throws IOException {

        PostDto postDto = this.postService.getPostById(postId);
        String fileName = this.fileService.uploadImage(path, image);

        postDto.setImageName(fileName);
        PostDto updatedPost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }



}