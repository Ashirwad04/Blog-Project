package Blog.Project.reposeteries;

import Blog.Project.entity.Category;
import Blog.Project.entity.Post;
import Blog.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post>findByUser(User user);
    List<Post>findByCategory(Category category);


}