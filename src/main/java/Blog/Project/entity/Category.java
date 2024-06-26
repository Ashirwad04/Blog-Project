package Blog.Project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotBlank
    @Size(min =3 )
    @Column(name = "title", length =100,nullable = false)
    private String categoryTitle;
    @NotBlank
    @Size(min =5 )
    @Column(name = "description")
    private String categoryDescription;


    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Post> posts=new ArrayList<Post>();


}