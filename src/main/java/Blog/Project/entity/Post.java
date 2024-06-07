package Blog.Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "title")
    private String title;

    @Column(name = "image_name")
    private String imageName;

    @Temporal(TemporalType.DATE)
    @Column(name = "add_date")
    private Date addDate;

    @Column(name = "content", length = 2055)
    private String content;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
   // @JoinColumn(name = "user_id")
    private User user;


}