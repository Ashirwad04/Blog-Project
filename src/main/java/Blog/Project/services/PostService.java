package Blog.Project.services;

import Blog.Project.paylods.PostDto;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto, Integer postId);

    //delete

    void deletePost(Integer postId);


    //get all
    List<PostDto> getAllPosts();

    //get BY id
    PostDto getPostById(Integer postId);


    //get all post by category

    List<PostDto> getPostByCategory(Integer categoryId);


    //get all post by user

    List<PostDto> getPostByUser(Integer userId);


    //search post
 //   List<PostDto> searchPost(String keyword);



}
