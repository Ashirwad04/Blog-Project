package Blog.Project.services;


import Blog.Project.paylods.PostDto;
import Blog.Project.paylods.PostResponse;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize);

    //get by id
    PostDto getPostById(Integer postId);

    //get all posts by category
    PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);

    //get all posts by user
    PostResponse getPostByUser(Integer userId, Integer pageNumber, Integer pageSize);


}
