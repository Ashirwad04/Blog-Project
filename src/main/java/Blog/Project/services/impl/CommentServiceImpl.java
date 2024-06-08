package Blog.Project.services.impl;

import Blog.Project.entity.Comment;
import Blog.Project.entity.Post;
import Blog.Project.exceptions.ResourceNotFoundException;
import Blog.Project.paylods.CommentDto;
import Blog.Project.paylods.PostResponse;
import Blog.Project.reposeteries.CommentRepository;
import Blog.Project.reposeteries.PostRepository;
import Blog.Project.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postResponse;


    @Autowired
    private ModelMapper modelMapper;



    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post=this.postResponse.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","post id",postId));
        Comment comment=this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment=this.commentRepository.save(comment);

        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment=this.commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","comment id",commentId));

            this.commentRepository.delete(comment);


    }
}
