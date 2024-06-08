package Blog.Project.services;

import Blog.Project.paylods.CommentDto;

public interface CommentService {


    CommentDto createComment(CommentDto comment,Integer postId);
    void deleteComment(Integer commentId);

}
